package com.example.shopmohinh.controller;

import com.example.shopmohinh.dto.request.ProductEventRequest;
import com.example.shopmohinh.dto.response.ApiResponse;
import com.example.shopmohinh.dto.response.ProductEventResponse;
import com.example.shopmohinh.service.EventProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EventController {
    EventProducerService eventProducerService;

    @PostMapping("/view")
    public ApiResponse<ProductEventResponse> sendViewEvent(@RequestBody ProductEventRequest event, HttpServletRequest request) {
        return ApiResponse.<ProductEventResponse>builder()
                .result(eventProducerService.sendEvent("product-view-events", event, request))
                .build();
    }

    @PostMapping("/search")
    public ApiResponse<ProductEventResponse> sendSearchEvent(@RequestBody ProductEventRequest event, HttpServletRequest request) {
        return ApiResponse.<ProductEventResponse>builder()
                .result(eventProducerService.sendEvent("product-search-events", event, request))
                .build();
    }

}
