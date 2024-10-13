package com.example.shopmohinh.dto.request;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateRequest {
    private String name;
    private Boolean sex;
    private String address;
    private String phone;
    private String email;
    private String status;
    private LocalDate date;
    private String pass;
    private LocalDateTime updatedDate;
    private String updatedBy;
    private List<Long> roles;
    private Boolean deleted;
}
