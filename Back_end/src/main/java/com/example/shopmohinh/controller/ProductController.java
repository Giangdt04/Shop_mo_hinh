package com.example.shopmohinh.controller;

import com.example.shopmohinh.dto.projection.CategoryTrendingProjection;
import com.example.shopmohinh.dto.projection.ProductTrendingProjection;
import com.example.shopmohinh.dto.request.ProductRequest;
import com.example.shopmohinh.dto.response.ApiResponse;
import com.example.shopmohinh.dto.response.ProductResponse;
import com.example.shopmohinh.dto.search.ProductSearch;
import com.example.shopmohinh.service.ElasticSearchService;
import com.example.shopmohinh.service.ProductService;
import com.example.shopmohinh.util.ClientIpUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/product")
@Slf4j
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    private final ElasticSearchService elasticSearchService;

    @GetMapping("/trending")
    public ApiResponse<List<ProductTrendingProjection>> productTrending() {
        List<ProductTrendingProjection> trending = productService.getProductTrendingOn7day();
        return ApiResponse.<List<ProductTrendingProjection>>builder()
                .result(trending)
                .build();
    }

    @GetMapping("/category_trending")
    public ApiResponse<List<CategoryTrendingProjection>> categoryTrending(@RequestParam(name = "intervalDate", defaultValue = "7") Integer intervalDate) {
        List<CategoryTrendingProjection> trending = productService.getCategoryTrending(intervalDate);
        return ApiResponse.<List<CategoryTrendingProjection>>builder()
                .result(trending)
                .build();
    }

    @GetMapping("/autocomplete")
    public ApiResponse<List<String>> autoComplete(@RequestParam String prefix,
                                                     @RequestParam(defaultValue = "8") int limit) {
        List<String> suggestions = elasticSearchService.autoCompleteSuggestions(prefix, limit);
        return ApiResponse.<List<String>>builder()
                .result(suggestions)
                .build();
    }

    @GetMapping("/search/recent")
    public ApiResponse<List<String>> getRecentSearch(@RequestParam(required = false) Long userId,
                                        HttpServletRequest request) {

        String ip = ClientIpUtils.getClientIp(request);

        return ApiResponse.<List<String>>builder()
                .result(productService.getSearchHistory(userId, ip))
                .build();
    }

    @DeleteMapping("/search-history")
    public ApiResponse<?> deleteKeyword(@RequestParam(required = false) Long userId,
                                           @RequestParam(required = false) String keyword,
                                           HttpServletRequest request) {
        String ip = ClientIpUtils.getClientIp(request);
        return ApiResponse.builder()
                .result(productService.deleteSearchKeyword(userId, ip, keyword))
                .build();
    }

    @PostMapping
    public ApiResponse<ProductResponse> create(@RequestBody ProductRequest request) {
        return ApiResponse.<ProductResponse>builder()
                .result(productService.create(request))
                .build();
    }

    @GetMapping
    public ApiResponse<Page<ProductResponse>> getAll(@NonNull ProductSearch request) {
        return ApiResponse.<Page<ProductResponse>>builder()
                .result(productService.getProduct(request))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ProductResponse> getById(@PathVariable Long id) {
        return ApiResponse.<ProductResponse>builder()
                .code(1000)
                .result(productService.getDetailProduct(id))
                .build();
    }


    @DeleteMapping("/{code}")
    public ApiResponse<ProductResponse> delete(@PathVariable("code") String code) {
        productService.delete(code);
        return ApiResponse.<ProductResponse>builder().build();
    }

    @PutMapping
    public ApiResponse<ProductResponse> updateUser(
            @RequestBody ProductRequest request) {
        return ApiResponse.<ProductResponse>builder()
                .result(productService.update(request))
                .build();

    }
}
