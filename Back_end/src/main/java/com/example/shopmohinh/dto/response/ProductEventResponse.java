package com.example.shopmohinh.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEventResponse {
    private Long productId;
    private String sessionId;
    private int actionType; // "VIEW" | "SEARCH"
    private String keyword; // dùng khi actionType = "SEARCH"
    private LocalDateTime timestamp ;
}
