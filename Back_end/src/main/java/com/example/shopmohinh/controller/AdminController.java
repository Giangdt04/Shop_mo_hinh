package com.example.shopmohinh.controller;

import com.example.shopmohinh.dto.request.UserCreationRequest;
import com.example.shopmohinh.dto.response.ApiResponse;
import com.example.shopmohinh.dto.response.UserResponse;
import com.example.shopmohinh.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    @Autowired
    private UserService userService;

    //thêm @Valid để create chạy validate
    @PostMapping()
    public ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.createdUser(request))
                .build();
    }
}
