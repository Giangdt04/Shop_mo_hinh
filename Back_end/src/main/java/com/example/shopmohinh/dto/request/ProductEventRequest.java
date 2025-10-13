package com.example.shopmohinh.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEventRequest {
    private Long productId;
    private int actionType;
    private String keyword;
}
