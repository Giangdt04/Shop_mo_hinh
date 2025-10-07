package com.example.shopmohinh.service;

public interface EventProducerService {
    <T> void sendEvent(String topic ,T Object);
    <T> void sendMessageJsonAsync(String topic, T object);
}
