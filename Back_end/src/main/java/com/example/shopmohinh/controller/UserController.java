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

    @GetMapping()
    public ApiResponse<List<UserResponse>>getUsers() {
//      SecurityContextHolder chứa user đang đăng nhập(Request)
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("username: {}", authentication.getName());

//       authentication.getAuthorities() trả về một tập hợp các quyền của người dùng
        authentication.getAuthorities()

//      forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority())) duyệt qua từng quyền và ghi log tên của từng quyền đó
                .forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));

        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getUsers())
                .build();
    }

    @GetMapping("/{code}")
    public ApiResponse<UserResponse> findUser(@PathVariable("code") String code) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.findUser(code))
                .build();
    }

    //chuyền vào token để lấy thông tin bản thân
    @GetMapping("/myInfo")
    public ApiResponse<UserResponse> getMyInfo(){
        return ApiResponse.<UserResponse>builder()
                .result(userService.getMyInfo())
                .build();
    }

    @PutMapping("/{code}")
    public ApiResponse<UserResponse> updateUser(@PathVariable("code") String code,
                           @RequestBody UserUpdateRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.userUpdate(code,request))
                .build();

    }

    @DeleteMapping("/{code}")
    public ApiResponse<UserResponse> deleteUser(@PathVariable("code") String code){
        return ApiResponse.<UserResponse>builder()
                .result(userService.deleteUser(code))
                .build();
    }
}
