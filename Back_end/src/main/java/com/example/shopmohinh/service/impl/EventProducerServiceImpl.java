package com.example.shopmohinh.service.impl;

import com.example.shopmohinh.service.EventProducerService;
import com.example.shopmohinh.util.CommonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EventProducerServiceImpl implements EventProducerService {
    @Autowired
    @Qualifier("taskExecutor")
    private Executor executor;

    KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public <T> void sendEvent(String topic , T object) {
        executor.execute(() -> this.sendMessageJsonAsync(topic, object));
    }

    public <T> void sendMessageJsonAsync(String topic, T object) {
        try{
            String message = CommonUtils.objectToJson(object);
            if(message != null && !message.isEmpty()){
                log.info("send message to topic `{}`",topic);
                kafkaTemplate.send(topic, message).get(); // Đợi Kafka xác nhận gửi thành công
                kafkaTemplate.flush(); // Ép đẩy buffer ra ngay
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
