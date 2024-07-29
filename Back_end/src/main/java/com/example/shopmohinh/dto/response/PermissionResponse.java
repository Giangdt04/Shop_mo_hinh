package com.example.shopmohinh.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionResponse {
    String name;

    LocalDateTime createdDate;

    LocalDateTime updatedDate;

    String createdBy;

    String updatedBy;

}
