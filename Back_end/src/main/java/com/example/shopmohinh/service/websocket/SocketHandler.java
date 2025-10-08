package com.example.shopmohinh.service.websocket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SocketHandler {
    private final SocketIOServer server;
    private static final Map<String, SocketIOClient> clients = new ConcurrentHashMap<>();

    @PostConstruct
    public void startServer() {
        server.start();
        server.addListeners(this);
        log.info("WebSocket Server started on port {}", server.getConfiguration().getPort());
    }

    @PreDestroy
    public void stopServer() {
        server.stop();
        log.info("WebSocket Server stopped");
    }

    @OnConnect
    public void onConnect(SocketIOClient client) {
        clients.put(client.getSessionId().toString(), client);
        log.info("Client connected: {}", client.getSessionId());
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        clients.remove(client.getSessionId().toString());
        log.info("Client disconnected: {}", client.getSessionId());
    }

    /**
     * Gửi dữ liệu realtime (view count, trending keyword, top product, ...)
     */
    public void broadcast(String event, Object data) {
        for (SocketIOClient client : clients.values()) {
            client.sendEvent(event, data);
        }
        log.debug("Broadcast event: {} -> {} clients", event, clients.size());
    }

}
