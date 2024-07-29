package com.example.shopmohinh.controller;

import com.example.shopmohinh.dto.request.CategoryRequest;
import com.example.shopmohinh.dto.request.RoleRequest;
import com.example.shopmohinh.dto.response.ApiResponse;
import com.example.shopmohinh.dto.response.CategoryResponse;
import com.example.shopmohinh.dto.response.RoleResponse;
import com.example.shopmohinh.service.CategoryService;
import com.example.shopmohinh.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public ApiResponse<CategoryResponse> create(@RequestBody CategoryRequest request){
        return ApiResponse.<CategoryResponse>builder()
                .result(categoryService.create(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<CategoryResponse>> getAll(){
        return ApiResponse.<List<CategoryResponse>>builder()
                .result(categoryService.getAll())
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable("id") Long id){
        categoryService.delete(id);
        return ApiResponse.<Void>builder().build();
    }

    @PutMapping("/{id}")
    public ApiResponse<CategoryResponse> updateUser(@PathVariable("id") Long id,
                                                @RequestBody CategoryRequest request) {
        return ApiResponse.<CategoryResponse>builder()
                .result(categoryService.update(id,request))
                .build();
    }
    @GetMapping("/{page}")
    public  ApiResponse<List<CategoryResponse>> getAllPaging(@PathVariable("page") Integer page){
        PageRequest pageRequest=PageRequest.of(page - 1,3);
        return ApiResponse.<List<CategoryResponse>>builder()
                .result(categoryService.getAllPaging(pageRequest))
                .build();
    }
    @GetMapping("/totalPage")
    public ApiResponse<Double> getAllTotalPage(){
        return ApiResponse.<Double>builder()
                .result(categoryService.getAllTotalPage())
                .build();
    }
    @GetMapping("/find")
    public ApiResponse<List<CategoryResponse>> findByAll(@RequestParam(value = "name",required = false) String name,@RequestParam(value = "status",required = false) Boolean status,@RequestParam Integer page){
        PageRequest pageRequest=PageRequest.of(page-1,3);
        return ApiResponse.<List<CategoryResponse>>builder()
                .result(categoryService.findByAll(name,status,pageRequest))
                .build();
    }

    @GetMapping("/findTotalPage")
    public ApiResponse<Double> findByAllTotalPage(@RequestParam(value = "name",required = false) String name,@RequestParam(value = "status",required = false) Boolean status){
        return ApiResponse.<Double>builder()
                .result(categoryService.findAllTotalPage(name,status))
                .build();    }
}
