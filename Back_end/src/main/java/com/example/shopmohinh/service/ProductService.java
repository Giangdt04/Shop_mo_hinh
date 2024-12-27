package com.example.shopmohinh.service;

import com.example.shopmohinh.dto.request.CategoryRequest;
import com.example.shopmohinh.dto.request.PermissionRequest;
import com.example.shopmohinh.dto.request.ProductRequest;
import com.example.shopmohinh.dto.response.CategoryResponse;
import com.example.shopmohinh.dto.response.PermissionResponse;
import com.example.shopmohinh.dto.response.ProductResponse;
import com.example.shopmohinh.dto.response.UserResponse;
import com.example.shopmohinh.entity.Category;
import com.example.shopmohinh.entity.Permission;
import com.example.shopmohinh.entity.Product;
import com.example.shopmohinh.entity.User;
import com.example.shopmohinh.exception.AppException;
import com.example.shopmohinh.exception.ErrorCode;
import com.example.shopmohinh.mapper.ProductMapper;
import com.example.shopmohinh.mapper.UserMapper;
import com.example.shopmohinh.repository.ProductRepository;
import com.example.shopmohinh.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
//Thay thế cho @Autowired
//@RequiredArgsConstructor sẽ tự động tạo contructor của những method đc khai báo là final
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Slf4j
public class ProductService {
    ProductRepository productRepository;

    ProductMapper productMapper;

    UserRepository userRepository;

    UserMapper userMapper;

    // lấy thông tin người đang đăng nhập
    public UserResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        User user = userRepository.findByUsername(name).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return userMapper.toUserResponse(user);
    }

    public ProductResponse create(ProductRequest request){

        Product product = productMapper.toProduct(request);

        if(productRepository.getTop1()==null){
            product.setCode("SP1");
        }else{
            String code = productRepository.getTop1().getCode();
            product.setCode(code.substring(0,2)+((Integer.parseInt(code.substring(2)))+1));
        }

        LocalDateTime now = LocalDateTime.now();

        product.setCreatedDate(now);

        Long id = getMyInfo().getId();

        product.setCreatedBy(String.valueOf(id));

        return productMapper.toProductResponse(productRepository.save(product));
    }

    public List<ProductResponse> getProduct(){

        var product = productRepository.findAll();

        return product.stream().map(productMapper::toProductResponse).toList();
    }

    public ProductResponse delete(String code){
        Product product = productRepository.findByCode(code)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        if(product != null){
            product.setDeleted(false);
        }

        return productMapper.toProductResponse(product);

    }

    public ProductResponse update(String code, ProductRequest request) {
        Product product = productRepository.findByCode(code).
                orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        productMapper.updateProduct(product, request);

        LocalDateTime now = LocalDateTime.now();

        product.setUpdatedDate(now);

        Long id = getMyInfo().getId();

        product.setUpdatedBy(String.valueOf(id));

        return productMapper.toProductResponse(productRepository.save(product));
    }
}
