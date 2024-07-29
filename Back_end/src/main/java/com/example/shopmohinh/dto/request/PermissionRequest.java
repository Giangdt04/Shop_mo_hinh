package com.example.shopmohinh.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionRequest {
    String name;

    LocalDateTime createdDate;

    LocalDateTime updatedDate;

    String createdBy;

    String updatedBy;

}
