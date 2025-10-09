package com.example.shopmohinh.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartDetailRequest {
    Integer quantity;

    Long productId;

}
