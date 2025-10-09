package com.example.shopmohinh.service;

import com.example.shopmohinh.dto.request.ProductEventRequest;
import com.example.shopmohinh.dto.response.ProductEventResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface EventProducerService {
    ProductEventResponse sendEvent(String topic , ProductEventRequest req, HttpServletRequest request);
}
