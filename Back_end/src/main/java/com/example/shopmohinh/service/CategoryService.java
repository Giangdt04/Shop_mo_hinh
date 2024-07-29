package com.example.shopmohinh.service;

import com.example.shopmohinh.dto.request.CategoryRequest;
import com.example.shopmohinh.dto.request.PermissionRequest;
import com.example.shopmohinh.dto.request.RoleRequest;
import com.example.shopmohinh.dto.response.CategoryResponse;
import com.example.shopmohinh.dto.response.PermissionResponse;
import com.example.shopmohinh.dto.response.RoleResponse;
import com.example.shopmohinh.dto.response.UserResponse;
import com.example.shopmohinh.entity.Category;
import com.example.shopmohinh.entity.Permission;
import com.example.shopmohinh.entity.Role;
import com.example.shopmohinh.entity.User;
import com.example.shopmohinh.exception.AppException;
import com.example.shopmohinh.exception.ErrorCode;
import com.example.shopmohinh.mapper.CategoryMapper;
import com.example.shopmohinh.mapper.UserMapper;
import com.example.shopmohinh.repository.CategoryRepository;
import com.example.shopmohinh.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

@Service
//Thay thế cho @Autowired
//@RequiredArgsConstructor sẽ tự động tạo contructor của những method đc khai báo là final
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Slf4j
public class CategoryService {
    CategoryRepository categoryRepository;

    CategoryMapper categoryMapper;

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

    public List<CategoryResponse> getAll(){

        var category = categoryRepository.getAll();

        return category.stream().map(categoryMapper::toCategoryResponse).toList();
    }
    public CategoryResponse create(CategoryRequest request){
        Category category = categoryMapper.toCategory(request);

        category = categoryRepository.save(category);

        LocalDateTime now = LocalDateTime.now();

        category.setCreatedDate(now);

        Long id = getMyInfo().getId();

        category.setCreatedBy(String.valueOf(id));

        return categoryMapper.toCategoryResponse(category);
    }

    public void delete(Long id){
        categoryRepository.deleteById(id);
    }

    public CategoryResponse update(Long Id, CategoryRequest request) {
        Category category = categoryRepository.findById(Id).
                orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        categoryMapper.updateCategory(category, request);

        LocalDateTime now = LocalDateTime.now();

        category.setUpdatedDate(now);

        Long id = getMyInfo().getId();

        category.setUpdatedBy(String.valueOf(id));

        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }
    public List<CategoryResponse> getAllPaging(Pageable pageable) {

        var category = categoryRepository.getAllPaging(pageable);

        return category.stream().map(categoryMapper::toCategoryResponse).toList();
    }
    public Double getAllTotalPage() {
        int totalPage=categoryRepository.getAllTotalPage().size();
        return Math.ceil(totalPage/3.0);
    }
    public CategoryResponse findUser(Long id) {
        log.info("In method get category by id");
        return categoryMapper.toCategoryResponse(categoryRepository.findById(id).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_EXISTED)
        ));
    }

    public List<CategoryResponse> findByAll(String name, Boolean status, Pageable pageable) {

        var category = categoryRepository.findByAll(name,status,pageable);

        return category.stream().map(categoryMapper::toCategoryResponse).toList();
    }

    public Double findAllTotalPage(String name, Boolean status) {
        int totalPage=categoryRepository.findAllTotalPage(name,status).size();
        return Math.ceil(totalPage/3.0);
    }
}