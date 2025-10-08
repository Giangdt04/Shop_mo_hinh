package com.example.shopmohinh.controller;

import com.example.shopmohinh.dto.search.ProductEventDTO;
import com.example.shopmohinh.service.EventProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EventController {
    EventProducerService eventProducerService;

    KafkaTemplate<String, String> kafkaTemplate;
    ObjectMapper objectMapper;

    @PostMapping("/view")
    public ResponseEntity<String> sendViewEvent(@RequestBody ProductEventDTO event) {
        eventProducerService.sendEvent("product-view-events", event);
        return ResponseEntity.ok("View event sent successfully!");
    }

    @PostMapping("/search")
    public ResponseEntity<String> sendSearchEvent(@RequestBody ProductEventDTO event) {
        eventProducerService.sendEvent("product-search-events", event);
        return ResponseEntity.ok("Search event sent successfully!");
    }

    @PostMapping("/product-view")
    public String sendProductViewEvent(@RequestBody ProductEventDTO event) throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(event);
        kafkaTemplate.send("product-view-events", message);
        return "Event sent to Kafka successfully!";
    }
}
