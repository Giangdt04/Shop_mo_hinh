package com.example.shopmohinh.service.kafka;

import com.example.shopmohinh.constant.ActionTypeConstant;
import com.example.shopmohinh.dto.response.ProductEventResponse;
import com.example.shopmohinh.service.websocket.SocketHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.example.shopmohinh.constant.ActionTypeConstant.TYPE_SEARCH;
import static com.example.shopmohinh.constant.ActionTypeConstant.TYPE_VIEW;
import static com.example.shopmohinh.constant.RedisKey.*;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RealTimeConsumer {
    StringRedisTemplate redisTemplate;
    ObjectMapper objectMapper;
    SocketHandler socketHandler;

    // === Lắng nghe sự kiện xem sản phẩm ===
    @KafkaListener(topics = "product-view-events", groupId = "real_time_group")
    public void listenView(String message) {
        try {
            ProductEventResponse event = objectMapper.readValue(message, ProductEventResponse.class);
            log.info(" Received VIEW event: {}", event);
            handleViewEvent(event);
        } catch (Exception e) {
            log.error(" Error processing VIEW event: {}", e.getMessage(), e);
        }
    }

    // === Lắng nghe sự kiện tìm kiếm sản phẩm ===
    @KafkaListener(topics = "product-search-events", groupId = "real_time_group")
    public void listenSearch(String message) {
        try {
            ProductEventResponse event = objectMapper.readValue(message, ProductEventResponse.class);
            log.info(" Received SEARCH event: {}", event);
            handleSearchEvent(event);
        } catch (Exception e) {
            log.error(" Error processing SEARCH event: {}", e.getMessage(), e);
        }
    }

    // === Xử lý sự kiện xem sản phẩm ===
    private void handleViewEvent(ProductEventResponse event) {
        Long productId = event.getProductId();
        String sessionId = event.getSessionId();

        if (sessionId == null || sessionId.isBlank()) {
            log.warn(" Missing sessionId → skip view count for product {}", productId);
            return;
        }

        String sessionViewKey = SESSION_VIEW_KEY + sessionId + ":" + productId;
        String productViewKey = PRODUCT_VIEW_KEY + productId;

        boolean alreadyViewed = Boolean.TRUE.equals(redisTemplate.hasKey(sessionViewKey));

        if (event.getActionType() == TYPE_VIEW.getValue()) {
            if (!alreadyViewed) {
                // chỉ đánh dấu đã xem, không set expire
                redisTemplate.opsForValue().increment(productViewKey);
                redisTemplate.opsForValue().set(sessionViewKey, "true", 1, TimeUnit.NANOSECONDS);
                log.info(" Counted new view for product {} this session", productId, sessionId);
            } else {
                log.info("⏱ Session {} already viewed product {} within 1h → skip", sessionId, productId);
            }
        }

        String count = redisTemplate.opsForValue().get(productViewKey);
        log.info(" Product [{}] total views = {}", productId, count);

        Map<String, Object> data = Map.of(
                "productId", productId,
                "viewCount", count != null ? count : "0"
        );
        socketHandler.broadcast("updateProductView", data);
    }

    // === Xử lý sự kiện tìm kiếm ===
    private void handleSearchEvent(ProductEventResponse event) {
        String keyword = event.getKeyword();
        String sessionId = event.getSessionId();

        if (keyword == null || keyword.isBlank()) {
            log.warn("️ Missing keyword → skip search count (session={})", sessionId);
            return;
        }
        if (sessionId == null || sessionId.isBlank()) {
            log.warn(" Missing sessionId → skip search count for keyword {}", keyword);
            return;
        }

        String sessionSearchKey = SESSION_SEARCH_KEY + sessionId + ":" + keyword;
        String keywordSearchKey = PRODUCT_SEARCH_KEY + keyword;

        boolean alreadySearched = Boolean.TRUE.equals(redisTemplate.hasKey(sessionSearchKey));

        if (event.getActionType() == TYPE_SEARCH.getValue()) {
            if (!alreadySearched) {
                redisTemplate.opsForValue().increment(keywordSearchKey);
                redisTemplate.opsForValue().set(sessionSearchKey, "true", 1, TimeUnit.SECONDS);
                log.info(" Counted new search for keyword '{}' (session={})", keyword, sessionId);
            } else {
                log.info("⏱ Session {} already searched keyword '{}' → skip", sessionId, keyword);
            }
        }

        String count = redisTemplate.opsForValue().get(keywordSearchKey);
        log.info(" Keyword [{}] total searches = {}", keyword, count);

        Map<String, Object> data = Map.of(
                "keyword", keyword,
                "keywordCount", count != null ? count : "0"
        );
        socketHandler.broadcast("updateKeywordSearch", data);
    }
}
