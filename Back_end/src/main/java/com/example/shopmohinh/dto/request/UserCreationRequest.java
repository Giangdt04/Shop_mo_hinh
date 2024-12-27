package com.example.shopmohinh.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//Access ModiFier
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {

    @NotEmpty(message = "Code cannot be empty")
    String code;

    @NotEmpty(message = "Name cannot be empty")
    String name;

    Boolean sex;

    String address;

    String phone;

    @NotEmpty(message = "Email cannot be empty")
    String email;

    String status;

    LocalDate date;

    @Size(min = 3,message = "USERNAME_INVALID")
    String username;

    //validate password
    @Size(min = 5,message = "PASSWORD_INVALID")
    String pass;

    LocalDateTime createdDate;

    String createdBy;

    private List<String> roles;
}
