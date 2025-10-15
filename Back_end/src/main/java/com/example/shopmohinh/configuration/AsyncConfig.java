package com.example.shopmohinh.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AsyncConfig {
    @Bean(name = "applicationTaskExecutor")
    @Primary // đánh dấu đây là executor mặc định
    public Executor applicationTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4); //Số lượng thread “cốt lõi” luôn được duy trì trong pool, dù rảnh rỗi
        executor.setMaxPoolSize(10); //Tối đa có thể có 10 thread chạy song song nếu workload cao.
        executor.setQueueCapacity(100); //Khi có thêm task, nếu 4 luồng đang bận, task mới sẽ được đưa vào hàng đợi (queue) — tối đa 100 task có thể chờ ở đây.
        executor.setThreadNamePrefix("AsyncExecutor-");
        executor.initialize();
        return executor;
    }
}
