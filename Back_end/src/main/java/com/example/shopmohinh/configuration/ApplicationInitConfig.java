package com.example.shopmohinh.configuration;

import com.example.shopmohinh.dto.request.UserCreationRequest;
import com.example.shopmohinh.entity.User;
import com.example.shopmohinh.repository.RoleRepository;
import com.example.shopmohinh.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

//@Configuration sẽ tự động chạy khi sạc application
@Configuration
//Thay thế cho @Autowired
//@RequiredArgsConstructor sẽ tự động tạo contructor của những method đc khai báo là final
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
//Để có thể logger được
@Slf4j
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;

    RoleRepository roleRepository;

    //ApplicationRunner sẽ đc khởi chạy mỗi khi application sạc lên
    //mục đích ở đây là auto khởi tạo 1 user admin nếu chưa có admin khi sạc application
    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository){
        return args -> {
            if(userRepository.findByUsername("admin").isEmpty()){
                User user = User.builder()
                        .username("admin")
                        .pass(passwordEncoder.encode("admin"))
                        .build();

                userRepository.save(user);
                log.warn("admin was has beem created with default username: admin, password: admin, please change it");
            }
        };
    }
}
