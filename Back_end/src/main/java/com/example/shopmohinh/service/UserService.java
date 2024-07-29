package com.example.shopmohinh.service;

import com.example.shopmohinh.dto.request.UserCreationRequest;
import com.example.shopmohinh.dto.request.UserUpdateRequest;
import com.example.shopmohinh.dto.response.UserResponse;
import com.example.shopmohinh.entity.User;
import com.example.shopmohinh.exception.AppException;
import com.example.shopmohinh.exception.ErrorCode;
import com.example.shopmohinh.mapper.UserMapper;
import com.example.shopmohinh.repository.RoleRepository;
import com.example.shopmohinh.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
//Thay thế cho @Autowired
//@RequiredArgsConstructor sẽ tự động tạo contructor của những method đc khai báo là final
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Slf4j
public class UserService {

     UserRepository userRepository;

     RoleRepository roleRepository;

     UserMapper userMapper;

    public UserResponse createdUser(UserCreationRequest request) {


//        Cách sử dụng @Builder
//        UserCreationRequest request1 = UserCreationRequest.builder()
//                .code("123")
//                .name("giang")
//                .build();

        if(userRepository.existsByCode(request.getCode()))
//            throw new RuntimeException("User existed.");
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPass(passwordEncoder.encode(request.getPass()));
        LocalDateTime now = LocalDateTime.now();
        user.setCreatedDate(now);
        Long id = getMyInfo().getId();
        user.setCreatedBy(String.valueOf(id));

        var roles = roleRepository.findAllById(request.getRoles());

        user.setRoles(new HashSet<>(roles));

        return userMapper.toUserResponse(userRepository.save(user));
    }

//    @PreAuthorize("hasAuthority('SHOW_USER')")+
    @PreAuthorize("hasRole('ADMIN')")
    //kiểm tra trc khi vào method nếu thỏa dk thì ms đc chạy method
    public List<UserResponse> getUsers() {
        log.info("In method getUser");
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse).toList();
    }

    //ngược lại với @PreAuthorize
    //kiểm tra ssau khi method chạy xong nếu thỏa dk thì result ms đc trả về
//    @PostAuthorize("hasRole('ADMIN')")

    //kiểm tra username đang đăng nhập có phải là đúng user response ko
    @PostAuthorize("returnObject.username == authentication.name")
    public UserResponse findUser(Long id) {
        log.info("In method get user by id");
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_EXISTED)
        ));
    }

    // lấy thông tin người đang đăng nhập
    public UserResponse getMyInfo(){
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        User user = userRepository.findByUsername(name).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return userMapper.toUserResponse(user);

    }

    public UserResponse userUpdate(Long userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId).
                orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        userMapper.updateUser(user, request);

        LocalDateTime now = LocalDateTime.now();
        user.setUpdatedDate(now);

        Long id = getMyInfo().getId();
        user.setUpdatedBy(String.valueOf(id));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPass(passwordEncoder.encode(request.getPass()));

        var roles = roleRepository.findAllById(request.getRoles());

        user.setRoles(new HashSet<>(roles));


        return userMapper.toUserResponse(userRepository.save(user));
    }

    //Xóa cứng
    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }
}
