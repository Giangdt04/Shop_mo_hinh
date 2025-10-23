package com.example.shopmohinh.service;

import com.example.shopmohinh.constant.RedisKey;
import com.example.shopmohinh.dto.projection.CategoryTrendingProjection;
import com.example.shopmohinh.dto.projection.ProductTrendingProjection;
import com.example.shopmohinh.dto.projection.ProductProjection;
import com.example.shopmohinh.dto.request.ImageRequest;
import com.example.shopmohinh.dto.request.ProductRequest;
import com.example.shopmohinh.dto.response.ImageResponse;
import com.example.shopmohinh.dto.response.ProductResponse;
import com.example.shopmohinh.dto.search.ProductSearch;
import com.example.shopmohinh.entity.ImageEntity;
import com.example.shopmohinh.entity.Product;
import com.example.shopmohinh.exception.AppException;
import com.example.shopmohinh.exception.ErrorCode;
import com.example.shopmohinh.mapper.ProductMapper;
import com.example.shopmohinh.repository.jpa.ImageRepository;
import com.example.shopmohinh.repository.jpa.ProductRepository;
import com.example.shopmohinh.repository.jpa.UserProductViewLogRepository;
import com.example.shopmohinh.util.ClientIpUtils;
import com.example.shopmohinh.util.FileUploadUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static com.example.shopmohinh.constant.RedisKey.HISTORY_SEARCH_IP_ADDRESS;
import static com.example.shopmohinh.constant.RedisKey.HISTORY_SEARCH_USER_ID;

@Service
//Thay thế cho @Autowired
//@RequiredArgsConstructor sẽ tự động tạo contructor của những method đc khai báo là final
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ProductService {
    ProductRepository productRepository;

    ProductMapper productMapper;

    FileUploadUtil fileUploadUtil;

    UserService userService;

    ImageRepository imageRepository;

    ElasticSearchService elasticSearchService;

    StringRedisTemplate redisTemplate;

    ObjectMapper objectMapper;

    HttpServletRequest httpServletRequest;

    UserProductViewLogRepository userProductViewLogRepository;

    @Transactional
    public ProductResponse create(ProductRequest request) {

        Product product = productMapper.toProduct(request);

        if (productRepository.getTop1() == null) {
            product.setCode("SP1");
        } else {
            String code = productRepository.getTop1().getCode();
            product.setCode(code.substring(0, 2) + ((Integer.parseInt(code.substring(2))) + 1));
        }

        LocalDateTime now = LocalDateTime.now();

        product.setCreatedDate(now);

        product.setCreatedBy(userService.getMyInfo().getUsername());

        Product saveProduct = productRepository.save(product);

        elasticSearchService.saveSearchProducts(saveProduct);

        this.setImages(saveProduct, request.getImages());

        return productMapper.toProductResponse(saveProduct);
    }

    private void setImages(Product product, List<ImageRequest> requests) {
        if (requests == null || requests.isEmpty()) return;

        List<ImageEntity> images = new ArrayList<>();

        for (ImageRequest request : requests) {
            String url = fileUploadUtil.uploadFile(request.getImageFile());

            ImageEntity img = new ImageEntity();
            img.setImageUrl(url);
            img.setMainImage(request.getMainImage());
            img.setProduct(product);

            images.add(img);
        }

        imageRepository.saveAll(images);
    }

    public Page<ProductResponse> getProduct(@NonNull ProductSearch request) {

        String ip = ClientIpUtils.getClientIp(httpServletRequest);

        this.saveSearchHistory(request, ip);

        Pageable pageable = PageRequest.of(request.getPageIndex() - 1, request.getPageSize());

        Page<ProductProjection> products = productRepository.getAll(request, pageable);

        return products.map(ProductResponse::new);
    }

    public List<String> getSearchHistory(Long userId, String ipAddress) {
        String key;
        if(userId != null) {
            key = HISTORY_SEARCH_USER_ID + userId;
        } else if(ipAddress != null) {
            key = HISTORY_SEARCH_IP_ADDRESS + ipAddress;
        } else {
            return Collections.emptyList();
        }

        List<String> recentKeywords = redisTemplate.opsForList().range(key, 0, 7);
        return recentKeywords != null ? recentKeywords : Collections.emptyList();
    }

    private void saveSearchHistory(ProductSearch request, String ipAddress) {
        if(request.getKeyword() == null || request.getKeyword().isBlank()) return;

        String key;
        if(request.getUserId() != null) {
            key = HISTORY_SEARCH_USER_ID + request.getUserId();
        } else {
            key = HISTORY_SEARCH_IP_ADDRESS + ipAddress;
        }

        // Xóa trùng
        redisTemplate.opsForList().remove(key, 0, request.getKeyword());
        // Thêm từ khóa mới vào đầu list
        redisTemplate.opsForList().leftPush(key, request.getKeyword());
        // Giữ tối đa 8 phần tử
        redisTemplate.opsForList().trim(key, 0, 7);
        // Optionally: set TTL
        redisTemplate.expire(key, Duration.ofDays(7));
    }

    public boolean deleteSearchKeyword(Long userId, String ipAddress, String keyword) {
        String key;
        if (userId != null) {
            key = HISTORY_SEARCH_USER_ID + userId;
        } else if (ipAddress != null) {
            key = HISTORY_SEARCH_IP_ADDRESS + ipAddress;
        } else {
            return false;
        }

        Long removed = redisTemplate.opsForList().remove(key, 0, keyword);
        return removed != null && removed > 0;
    }

    public ProductResponse getDetailProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        List<ImageEntity> images = imageRepository.findByProduct(product);
        ProductResponse response = productMapper.toProductResponse(product);

        if(!ObjectUtils.isEmpty(images)){
            List<ImageResponse> imageResponses = images.stream()
                    .map(img -> new ImageResponse(img.getId(), img.getImageUrl(), img.isMainImage()))
                    .collect(Collectors.toList());
            response.setImages(imageResponses);
        }

        try {
            var currentUser = userService.getMyInfo(); // có thể null nếu chưa login
            Long userId = currentUser != null ? currentUser.getId() : null;

            this.recordView(
                    product.getId(),
                    product.getCategory().getId(),
                    userId
            );

        } catch (Exception e) {
            log.error("Error recording product view in Redis: {}", e.getMessage());
        }


        return response;
    }

    public void recordView(Long productId, Long categoryId, Long userId) {
        if (productId == null) {
            log.warn("productId is null → skip");
            return;
        }

        Map<String, Object> logItem = new HashMap<>();
        logItem.put("userId", userId);
        logItem.put("productId", productId);
        logItem.put("categoryId", categoryId);
        logItem.put("viewedAt", LocalDateTime.now().toString());
        logItem.put("actionType", 1);                        // action_type = 1 = PRODUCT

        try {
            String redisKey = RedisKey.PRODUCT_LOG_KEY_PREFIX + productId;
            String json = objectMapper.writeValueAsString(logItem);

            // Push vào Redis list
            redisTemplate.opsForList().rightPush(redisKey, json);

            log.info("Recorded product view log in Redis for product {} (userId={})", productId, userId);
        } catch (Exception e) {
            log.error("Failed to record product view log in Redis: {}", e.getMessage(), e);
        }
    }

    public ProductResponse delete(String code) {
        Product product = productRepository.findByCode(code)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        if (product != null) {
            product.setDeleted(false);
            elasticSearchService.delete(product);
        }

        return productMapper.toProductResponse(product);

    }

    public ProductResponse update(ProductRequest request) {
        Product product = productRepository.findByCode(request.getCode()).
                orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        productMapper.updateProduct(product, request);

        LocalDateTime now = LocalDateTime.now();

        product.setUpdatedDate(now);

        String userName = userService.getMyInfo().getUsername();

        product.setUpdatedBy(userName);

        Product updateProduct = productRepository.save(product);

        elasticSearchService.updateByProjectSearch(updateProduct);

        this.setImages(updateProduct, request.getImages());

        return productMapper.toProductResponse(updateProduct);
    }

    public List<ProductTrendingProjection> getProductTrendingOn7day() {
        List<ProductTrendingProjection> productTrending = userProductViewLogRepository.getTop3ProductTrendingOn7day();
        if(ObjectUtils.isEmpty(productTrending)){
            return Collections.emptyList();
        }
        return productTrending;
    }

    public List<CategoryTrendingProjection> getCategoryTrending(Integer intervalDate) {
        List<CategoryTrendingProjection> categoryTrending = userProductViewLogRepository.getTop5CategoryTrending(intervalDate);
        if(ObjectUtils.isEmpty(categoryTrending)){
            return Collections.emptyList();
        }
        return categoryTrending;
    }
}
