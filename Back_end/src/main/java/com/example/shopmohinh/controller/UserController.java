package com.example.shopmohinh.controller;

import com.example.shopmohinh.dto.request.UserCreationRequest;
import com.example.shopmohinh.dto.request.UserUpdateRequest;
import com.example.shopmohinh.dto.response.ApiResponse;
import com.example.shopmohinh.dto.response.UserResponse;
import com.example.shopmohinh.entity.User;
import com.example.shopmohinh.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    //thêm @Valid để create chạy validate
    @PostMapping("/createUser")
    public ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.createdUser(request))
                .build();
    }

    @GetMapping("/showUser")
    public ApiResponse<List<UserResponse>>getUsers() {
//      SecurityContextHolder chứa user đang đăng nhập(Request)
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));

        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getUsers())
                .build();
    }

    @GetMapping("/{userId}")
    public ApiResponse<UserResponse> findUser(@PathVariable("userId") Long userId) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.findUser(userId))
                .build();
    }

    //chuyền vào token để lấy thông tin bản thân
    @GetMapping("/myInfo")
    public ApiResponse<UserResponse> getMyInfo(){
        return ApiResponse.<UserResponse>builder()
                .result(userService.getMyInfo())
                .build();
    }

    @PutMapping("/{userId}")
    public ApiResponse<UserResponse> updateUser(@PathVariable("userId") Long userId,
                           @RequestBody UserUpdateRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.userUpdate(userId,request))
                .build();

    }

    @DeleteMapping("/{userId}")
    ApiResponse<String> deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
        return ApiResponse.<String>builder()
                .result("User has been deleted")
                .build();
    }
}
