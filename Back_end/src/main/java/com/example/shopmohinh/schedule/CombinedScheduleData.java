package com.example.shopmohinh.schedule;

import com.example.shopmohinh.constant.RedisKey;
import com.example.shopmohinh.entity.HotStatistics;
import com.example.shopmohinh.entity.UserProductViewLogEntity;
import com.example.shopmohinh.repository.jpa.HotStatisticsRepository;
import com.example.shopmohinh.repository.jpa.UserProductViewLogRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.nimbusds.jose.shaded.gson.JsonSyntaxException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.shopmohinh.constant.ActionTypeConstant.TYPE_SEARCH;
import static com.example.shopmohinh.constant.ActionTypeConstant.TYPE_VIEW;
import static com.example.shopmohinh.constant.RedisKey.KEYWORD_SEARCH_KEY;
import static com.example.shopmohinh.constant.RedisKey.PRODUCT_VIEW_KEY;

@Slf4j
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CombinedScheduleData {
    HotStatisticsRepository hotStatisticsRepository;

    StringRedisTemplate redisTemplate;

    UserProductViewLogRepository userProductViewLogRepository;

//     Cron: "0 0 */12 * * ?" → 0 phút, 0 giây, mỗi 12 tiếng 1 lần
    @Scheduled(cron = "0 0 */12 * * ?")
    public void syncTopDataToDatabase() {
        log.info("Bắt đầu tiến trình đồng bộ top dữ liệu từ Redis sang MySQL");

        try {
            processHotData(PRODUCT_VIEW_KEY + "*", TYPE_VIEW.getValue(), true);
            processHotData( KEYWORD_SEARCH_KEY + "*", TYPE_SEARCH.getValue(), false);
        } catch (Exception e) {
            log.error("Lỗi khi đồng bộ dữ liệu hot_statistics: ", e);
        }

        log.info("Kết thúc tiến trình đồng bộ");
    }

    //clear data cũ hơn 180 ngày vào 3h sáng mỗi đầu tháng
    @Scheduled(cron = "0 0 3 1 * ?")
    public void cleanupOldData() {
        LocalDateTime cutoffDate = LocalDateTime.now().minusDays(180);
        log.info(" Bắt đầu dọn dẹp dữ liệu hot_statistics cũ hơn: {}", cutoffDate);

        try {
            int deleted = hotStatisticsRepository.deleteByCreatedAtBefore(cutoffDate);
            log.info(" Đã xóa {} bản ghi cũ trong hot_statistics", deleted);
        } catch (Exception e) {
            log.error("Lỗi khi xóa dữ liệu cũ hot_statistics", e);
        }
    }


    @Scheduled(cron = "0 0/5 * * * *")
    public void flushProductLogs() {
        try {
            Set<String> keys = redisTemplate.keys(RedisKey.PRODUCT_LOG_KEY_PREFIX + "*");
            if (keys == null || keys.isEmpty()) return;

            // Tạo Gson có TypeAdapter cho LocalDateTime
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>)
                            (json, type, context) -> LocalDateTime.parse(json.getAsString()))
                    .create();

            for (String key : keys) {
                List<String> items = redisTemplate.opsForList().range(key, 0, -1);
                if (items == null || items.isEmpty()) continue;

                List<UserProductViewLogEntity> entities = items.stream().map(json -> {
                    try {
                        return gson.fromJson(json, UserProductViewLogEntity.class);
                    } catch (JsonSyntaxException e) {
                        log.error("Failed to parse Redis JSON: {}", e.getMessage(), e);
                        return null;
                    }
                }).filter(Objects::nonNull).collect(Collectors.toList());

                if (!entities.isEmpty()) {
                    userProductViewLogRepository.saveAll(entities);
                    log.info("Flushed {} product view logs from Redis key {} to DB", entities.size(), key);
                }

                redisTemplate.delete(key);
            }

        } catch (Exception e) {
            log.error("Error flushing product view logs from Redis: {}", e.getMessage(), e);
        }
    }


    private void processHotData(String pattern, int type, boolean isProduct) {
        Set<String> keys = redisTemplate.keys(pattern);
        if (ObjectUtils.isEmpty(keys)) {
            log.info("Không có dữ liệu {} trong Redis để đồng bộ", isProduct ? "sản phẩm" : "từ khóa");
            return;
        }

        LocalDateTime now = LocalDateTime.now();

        // Dùng parallelStream để tăng tốc nếu key nhiều
        List<HotStatistics> top10 = keys.parallelStream()
                .map(key -> mapToHotStatistics(key, type, isProduct, now))
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingLong(HotStatistics::getCountValue).reversed())
                .limit(10)
                .collect(Collectors.toList());

        if (!top10.isEmpty()) {
            hotStatisticsRepository.saveAll(top10);
            log.info("Đã lưu top 10 {} hot nhất vào hot_statistics", isProduct ? "sản phẩm" : "từ khóa");
        }
    }

    /**
     * Chuyển key Redis thành đối tượng HotStatistics.
     */
    private HotStatistics mapToHotStatistics(String key, int type, boolean isProduct, LocalDateTime now) {
        try {
            String countStr = redisTemplate.opsForValue().get(key);
            long count = countStr != null ? Long.parseLong(countStr) : 0;

            if (count <= 0) return null;

            if (isProduct) {
                long productId = Long.parseLong(key.replace(PRODUCT_VIEW_KEY, ""));
                return HotStatistics.builder()
                        .type(type)
                        .productId(productId)
                        .countValue(count)
                        .createdAt(now)
                        .build();
            } else {
                String keyword = key.replace(KEYWORD_SEARCH_KEY, "");
                return HotStatistics.builder()
                        .type(type)
                        .keyword(keyword)
                        .countValue(count)
                        .createdAt(now)
                        .build();
            }
        } catch (Exception e) {
            log.warn("Bỏ qua key không hợp lệ: {}", key);
            return null;
        }
    }
}
