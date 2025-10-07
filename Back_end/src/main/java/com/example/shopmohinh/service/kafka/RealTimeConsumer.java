package com.example.shopmohinh.service.kafka;

import com.example.shopmohinh.dto.search.ProductEventDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RealTimeConsumer {
    StringRedisTemplate redisTemplate;

    ObjectMapper objectMapper;

    @KafkaListener(topics = "product-view-events", groupId = "real_time_group")
    public void listen(String message) {
        try {
            ProductEventDTO event = objectMapper.readValue(message, ProductEventDTO.class);
            log.info(" Received product event: {}", event);

            // Gọi hàm cập nhật Redis
            this.handleViewEvent(event);

        } catch (Exception e) {
            log.error("Error processing event: {}", e.getMessage());
        }
    }

    private void handleViewEvent(ProductEventDTO event) {
        Long productId = event.getProductId();
        String sessionId = event.getSessionId();

        if (sessionId == null || sessionId.isBlank()) {
            log.warn("Missing sessionId → skip view count for product {}", productId);
            return;
        }

        // Redis keys
        String sessionViewKey = "viewed:" + sessionId + ":" + productId;
        String productViewKey = "product:view:" + productId;

        // Nếu session chưa xem trong 1h → tăng
        boolean alreadyViewed = Boolean.TRUE.equals(redisTemplate.hasKey(sessionViewKey));

        if (!alreadyViewed) {
            redisTemplate.opsForValue().increment(productViewKey);
            redisTemplate.opsForValue().set(sessionViewKey, "1", 1, TimeUnit.HOURS);
            log.info("Counted new view for product {} by session {}", productId, sessionId);
        } else {
            log.info("⏱ Session {} already viewed product {} within 1h → skip", sessionId, productId);
        }

        String count = redisTemplate.opsForValue().get(productViewKey);
        log.info("Product [{}] total views = {}", productId, count);
    }
}
