package com.example.shopmohinh.controller;

import com.example.shopmohinh.dto.request.ProductRequest;
import com.example.shopmohinh.dto.request.RoleRequest;
import com.example.shopmohinh.dto.response.ApiResponse;
import com.example.shopmohinh.dto.response.ProductResponse;
import com.example.shopmohinh.dto.response.RoleResponse;
import com.example.shopmohinh.service.PermissionService;
import com.example.shopmohinh.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public ApiResponse<ProductResponse> create(@RequestBody ProductRequest request){
        return ApiResponse.<ProductResponse>builder()
                .result(productService.create(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<ProductResponse>> getAll(){
        return ApiResponse.<List<ProductResponse>>builder()
                .result(productService.getProduct())
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable("id") Long id){
        productService.delete(id);
        return ApiResponse.<Void>builder().build();
    }

    @PutMapping("/{id}")
    public ApiResponse<ProductResponse> updateUser(@PathVariable("id") Long id,
                                                @RequestBody ProductRequest request) {
        return ApiResponse.<ProductResponse>builder()
                .result(productService.update(id,request))
                .build();

    }
}
