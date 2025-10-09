package com.example.shopmohinh.configuration.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic productViewTopic() {
        return TopicBuilder.name("product-view-events")
                .partitions(3)
                .replicas(1)
                // Dữ liệu lượt xem có thể xóa sau 24h (không cần lưu mãi)
                .config(TopicConfig.RETENTION_MS_CONFIG, "86400000") // 24h
                .config(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE)
                .build();
    }

    @Bean
    public NewTopic productSearchTopic() {
        return TopicBuilder.name("product-search-events")
                .partitions(3)
                .replicas(1)
                .build();
    }
}
