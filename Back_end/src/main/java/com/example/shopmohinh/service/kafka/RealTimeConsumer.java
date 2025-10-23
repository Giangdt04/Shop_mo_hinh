package com.example.shopmohinh.service.kafka;

import com.corundumstudio.socketio.SocketIOClient;
import com.example.shopmohinh.dto.response.ProductEventResponse;
import com.example.shopmohinh.dto.response.Top10KeywordsUpdateEvent;
import com.example.shopmohinh.dto.response.Top10ProductsUpdateEvent;
import com.example.shopmohinh.service.websocket.SocketHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static com.example.shopmohinh.constant.ActionTypeConstant.TYPE_SEARCH;
import static com.example.shopmohinh.constant.ActionTypeConstant.TYPE_VIEW;
import static com.example.shopmohinh.constant.RedisKey.*;
import static com.example.shopmohinh.constant.RedisKey.TOP_KEYWORD_SEARCH;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RealTimeConsumer {
    StringRedisTemplate redisTemplate;
    ObjectMapper objectMapper;
    ApplicationEventPublisher publisher;

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
                redisTemplate.opsForZSet().incrementScore(TOP_PRODUCT_VIEWS, String.valueOf(event.getProductId()), 1);
                redisTemplate.opsForValue().set(sessionViewKey, "true", 1, TimeUnit.NANOSECONDS);
                log.info(" Counted new view for product {} this session", productId, sessionId);
            } else {
                log.info("⏱ Session {} already viewed product {} within 1h → skip", sessionId, productId);
            }
        }

        String count = redisTemplate.opsForValue().get(productViewKey);
        log.info(" Product [{}] total views = {}", productId, count);

        this.sendTop10Products();
    }

    private void handleSearchEvent(ProductEventResponse event) {
        String keyword = event.getKeyword();
        String sessionId = event.getSessionId();

        if (keyword.isBlank()) {
            log.warn("️ Missing keyword → skip search count (session={})", sessionId);
            return;
        }
        if (sessionId == null || sessionId.isBlank()) {
            log.warn(" Missing sessionId → skip search count for keyword {}", keyword);
            return;
        }

        String sessionSearchKey = SESSION_SEARCH_KEY + sessionId + ":" + keyword;
        String keywordSearchKey = KEYWORD_SEARCH_KEY + keyword;

        boolean alreadySearched = Boolean.TRUE.equals(redisTemplate.hasKey(sessionSearchKey));

        if (event.getActionType() == TYPE_SEARCH.getValue()) {
            if (!alreadySearched) {
                redisTemplate.opsForValue().increment(keywordSearchKey);
                redisTemplate.opsForZSet().incrementScore(TOP_KEYWORD_SEARCH, String.valueOf(event.getKeyword()), 1);
                redisTemplate.opsForValue().set(sessionSearchKey, "true", 1, TimeUnit.SECONDS);
                log.info(" Counted new search for keyword '{}' (session={})", keyword, sessionId);
            } else {
                log.info("⏱ Session {} already searched keyword '{}' → skip", sessionId, keyword);
            }
        }

        String count = redisTemplate.opsForValue().get(keywordSearchKey);
        log.info(" Keyword [{}] total searches = {}", keyword, count);

        this.sendTop10Keywords();
    }

    public void sendTop10Products() {
//      ZSet (sorted set)
        var top10 = redisTemplate.opsForZSet().reverseRangeWithScores(TOP_PRODUCT_VIEWS, 0, 9);
        if (top10 == null || top10.isEmpty()) return;

        List<Map<String, Object>> list = top10.stream().map(e -> {
            Map<String, Object> map = new HashMap<>();
            map.put("productId", e.getValue());
            map.put("viewCount", Objects.requireNonNull(e.getScore()).longValue());
            return map;
        }).toList();
        publisher.publishEvent(new Top10ProductsUpdateEvent(this, list));

    }

    public void sendTop10Keywords() {
        var top10 = redisTemplate.opsForZSet().reverseRangeWithScores(TOP_KEYWORD_SEARCH, 0, 9);
        if (top10 == null || top10.isEmpty()) return;

        List<Map<String, Object>> list = top10.stream().map(e -> {
            Map<String, Object> map = new HashMap<>();
            map.put("keyword", e.getValue());
            map.put("searchCount", Objects.requireNonNull(e.getScore()).longValue());
            return map;
        }).toList();
        publisher.publishEvent(new Top10KeywordsUpdateEvent(this, list));
    }

    public List<Map<String,Object>> getTop10ProductsList() {
        var top10 = redisTemplate.opsForZSet().reverseRangeWithScores(TOP_PRODUCT_VIEWS, 0, 9);
        if (top10 == null || top10.isEmpty()) return List.of();

        return top10.stream().map(e -> {
            Map<String,Object> map = new HashMap<>();
            map.put("productId", e.getValue());
            map.put("viewCount", Objects.requireNonNull(e.getScore()).longValue());
            return map;
        }).toList();
    }

    public List<Map<String,Object>> getTop10keywordsList() {
        var top10 = redisTemplate.opsForZSet().reverseRangeWithScores(TOP_KEYWORD_SEARCH, 0, 9);
        if (top10 == null || top10.isEmpty()) return List.of();

        return top10.stream().map(e -> {
            Map<String,Object> map = new HashMap<>();
            map.put("keyword", e.getValue());
            map.put("searchCount", Objects.requireNonNull(e.getScore()).longValue());
            return map;
        }).toList();
    }

}
