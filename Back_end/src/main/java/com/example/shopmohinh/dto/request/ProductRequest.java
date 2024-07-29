package com.example.shopmohinh.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {
    String code;

    String name;

    String description;

    Boolean status;

    String hight;

    String weight;

    Long quantity;

    Double price;

    Long category_id;
}
