package com.example.shopmohinh.configuration;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SocketIOConfig {
    @Bean
    public SocketIOServer socketIOServer() {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setPort(8099);     // Port Socket.IO server chạy (client sẽ kết nối ws://localhost:8099)
        config.setOrigin("*");    // Cho phép tất cả domain connect
        return new SocketIOServer(config);
    }
}
