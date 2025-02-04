package com.example.shopmohinh.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.shopmohinh.dto.request.UserCreationRequest;
import com.example.shopmohinh.dto.request.UserUpdateRequest;
import com.example.shopmohinh.dto.response.UserResponse;
import com.example.shopmohinh.entity.Role;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Service
//Thay thế cho @Autowired
//@RequiredArgsConstructor sẽ tự động tạo contructor của những method đc khai báo là final
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService {

    UserRepository userRepository;

    RoleRepository roleRepository;

    UserMapper userMapper;

    Cloudinary cloudinary;

    public UserResponse createdUser(UserCreationRequest request) {

        // Kiểm tra xem tài khoản với username "admin" đã tồn tại chưa
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        User user = userMapper.toUser(request);
        user.setCode(this.generateCode());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPass(passwordEncoder.encode(request.getPass()));
        LocalDateTime now = LocalDateTime.now();
        user.setCreatedDate(now);
        Long id = getMyInfo().getId();
        user.setCreatedBy(String.valueOf(id));
        user.setAvatar(uploadAvatar(request.getAvatarFile()));

        // Lấy role từ request
        Set<Role> roles = getRolesFromRequest(request.getRoles());
        user.setRoles(roles);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    private String generateCode() {
        String lastCode = Optional.ofNullable(userRepository.getTop1())
                .map(User::getCode)
                .orElse("USER000");

        if (lastCode.length() > 6) {
            String prefix = lastCode.substring(0, 6);
            int number = Integer.parseInt(lastCode.substring(6));
            return prefix + (number + 1);
        } else {
            return "USER001";
        }
    }

    private Set<Role> getRolesFromRequest(List<String> roleCodes) {
        Set<Role> roles = new HashSet<>();

        // Nếu roleCodes null hoặc rỗng, gán role mặc định là "USER"
        if (roleCodes == null || roleCodes.isEmpty()) {
            Optional<Role> userRoleOptional = roleRepository.findRoleByCode("USER");
            if (userRoleOptional.isEmpty()) {
                throw new AppException(ErrorCode.ROLE_NOT_FOUND); // Nếu không tìm thấy role "USER"
            }
            roles.add(userRoleOptional.get());
        } else {
            // Lấy role từ danh sách roleCodes
            for (String roleCode : roleCodes) {
                Optional<Role> userRoleOptional = roleRepository.findRoleByCode(roleCode);
                if (userRoleOptional.isPresent()) {
                    roles.add(userRoleOptional.get());
                } else {
                    throw new AppException(ErrorCode.ROLE_NOT_FOUND);
                }
            }
        }
        return roles;
    }

    @PreAuthorize("hasAuthority('SHOW_USER')")
//    @PreAuthorize("hasRole('ADMIN')")
    //kiểm tra trc khi vào method nếu thỏa dk thì ms đc chạy method
    public List<UserResponse> getUsers() {
        log.info("In method getUser");
        return userRepository.getAll().stream()
                .map(userMapper::toUserResponse).toList();
    }

    //ngược lại với @PreAuthorize
    //kiểm tra ssau khi method chạy xong nếu thỏa dk thì result ms đc trả về
//    @PostAuthorize("hasRole('ADMIN')")

    //kiểm tra username đang đăng nhập có phải là đúng user response ko
    @PostAuthorize("returnObject.username == authentication.name")
    public UserResponse findUser(String code) {
        log.info("In method get user by id");
        return userMapper.toUserResponse(userRepository.findByCode(code).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_EXISTED)
        ));
    }

    // lấy thông tin người đang đăng nhập
    public UserResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        User user = userRepository.findByUsername(name).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return userMapper.toUserResponse(user);
    }

//    @PreAuthorize("hasAuthority('UPDATE_USER')")
    public UserResponse userUpdate(String code, UserUpdateRequest request) {
        User user = userRepository.findByCode(code).
                orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        userMapper.updateUser(user, request);

        LocalDateTime now = LocalDateTime.now();
        user.setUpdatedDate(now);

        Long id = getMyInfo().getId();
        user.setUpdatedBy(String.valueOf(id));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPass(passwordEncoder.encode(request.getPass()));

        if (request.getAvatarFile() != null && !request.getAvatarFile().isEmpty()) {
            user.setAvatar(uploadAvatar(request.getAvatarFile()));
        }

        var roles = roleRepository.findAllById(request.getRoles());

        user.setRoles(new HashSet<>(roles));


        return userMapper.toUserResponse(userRepository.save(user));
    }


    public UserResponse deleteUser(String code){
        User user = userRepository.findByCode(code).
                orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        user.setDeleted(false);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    private String uploadAvatar(MultipartFile avatarFile) {
        if (avatarFile != null && !avatarFile.isEmpty()) {
            try {
                return uploadFile(avatarFile);
            } catch (IOException e) {
                log.error("Error uploading file: {}", e.getMessage());
                throw new AppException(ErrorCode.FILE_UPLOAD_FAILED);
            }
        }
        log.warn("No avatar file provided, using default avatar URL.");
        return "https://asset.cloudinary.com/dvxobkvcx/ec27e05c5476c3c95ce0d4cc48841456";
    }

    public String uploadFile(MultipartFile file) throws IOException {
        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new AppException(ErrorCode.INVALID_FILE_TYPE);
        }

        try {
            Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            return uploadResult.get("url").toString();
        } catch (IOException e) {
            log.error("Upload file failed: {}", e.getMessage());
            throw new AppException(ErrorCode.FILE_UPLOAD_FAILED);
        }
    }
}
