package com.example.shopmohinh.schedule;

import com.example.shopmohinh.entity.HotStatistics;
import com.example.shopmohinh.repository.HotStatisticsRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CombinedScheduleData {
    HotStatisticsRepository hotStatisticsRepository;

    StringRedisTemplate redisTemplate;

//     Tiến trình này sẽ chạy mỗi 12 tiếng 1 lần
//     Cron: "0 0 */12 * * ?" → 0 phút, 0 giây, mỗi 12 tiếng 1 lần
    @Scheduled(cron = "0 0 */12 * * ?")
    public void syncTopDataToDatabase() {
        log.info("=== Bắt đầu tiến trình đồng bộ top dữ liệu từ Redis sang MySQL ===");

        try {
            saveTop10Products();
            saveTop10Keywords();
        } catch (Exception e) {
            log.error("Lỗi khi đồng bộ dữ liệu hot_statistics: ", e);
        }

        log.info("=== Kết thúc tiến trình đồng bộ ===");
    }

    private void saveTop10Products() {
        // Lấy tất cả key theo pattern
        Set<String> keys = redisTemplate.keys("product:viewCount:*");
        if (keys == null || keys.isEmpty()) return;

        // Lấy (id, count)
        List<HotStatistics> top10 = keys.stream()
                .map(key -> {
                    String countStr = redisTemplate.opsForValue().get(key);
                    long count = countStr != null ? Long.parseLong(countStr) : 0;
                    long productId = Long.parseLong(key.replace("product:viewCount:", ""));
                    HotStatistics h = new HotStatistics();
                    h.setType(0); // 0 = product
                    h.setProductId(productId);
                    h.setCountValue(count);
                    h.setCreatedAt(LocalDateTime.now());
                    return h;
                })
                .sorted(Comparator.comparingLong(HotStatistics::getCountValue).reversed())
                .limit(10)
                .collect(Collectors.toList());

        hotStatisticsRepository.saveAll(top10);
        log.info("Đã lưu top 10 sản phẩm hot nhất vào hot_statistics");
    }

    private void saveTop10Keywords() {
        // Lấy tất cả key theo pattern
        Set<String> keys = redisTemplate.keys("search:keyword:*");
        if (keys == null || keys.isEmpty()) return;

        // Lấy (keyword, count)
        List<HotStatistics> top10 = keys.stream()
                .map(key -> {
                    String countStr = redisTemplate.opsForValue().get(key);
                    long count = countStr != null ? Long.parseLong(countStr) : 0;
                    String keyword = key.replace("search:keyword:", "");
                    HotStatistics h = new HotStatistics();
                    h.setType(1); // 1 = keyword
                    h.setKeyword(keyword);
                    h.setCountValue(count);
                    h.setCreatedAt(LocalDateTime.now());
                    return h;
                })
                .sorted(Comparator.comparingLong(HotStatistics::getCountValue).reversed())
                .limit(10)
                .collect(Collectors.toList());

        hotStatisticsRepository.saveAll(top10);
        log.info("Đã lưu top 10 từ khóa tìm kiếm nhiều nhất vào hot_statistics");
    }
}
