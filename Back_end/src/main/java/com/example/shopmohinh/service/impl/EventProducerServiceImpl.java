package com.example.shopmohinh.service.impl;

import com.example.shopmohinh.constant.ActionTypeConstant;
import com.example.shopmohinh.dto.request.ProductEventRequest;
import com.example.shopmohinh.dto.response.ProductEventResponse;
import com.example.shopmohinh.mapper.ProductEventMapper;
import com.example.shopmohinh.service.EventProducerService;
import com.example.shopmohinh.util.CommonUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.Executor;

import static com.example.shopmohinh.constant.ActionTypeConstant.TYPE_VIEW;
import static com.example.shopmohinh.util.ClientIpUtils.getClientIp;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EventProducerServiceImpl implements EventProducerService {
    ProductEventMapper productEventMapper;

    @Autowired
    @Qualifier("taskExecutor")
    private Executor executor;

    KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public ProductEventResponse sendEvent(String topic, ProductEventRequest req, HttpServletRequest request) {
        try {
            ProductEventResponse response = productEventMapper.toProductEventResponse(req);
            response.setSessionId(getClientIp(request));
            response.setTimestamp(LocalDateTime.now());
            if (response.getSessionId() != null || !response.getSessionId().isBlank()) {
                executor.execute(() -> this.sendMessageJsonAsync(topic, response));
            }
            return response;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private void sendMessageJsonAsync(String topic, ProductEventResponse object) {
        try {
            String message = CommonUtils.objectToJson(object);
            if (message == null && message.isEmpty()) return;
            int partition;

            if (object.getActionType() == TYPE_VIEW.getValue()) {
                String keyword = object.getKeyword();
                if (keyword == null || keyword.isEmpty()) {
                    partition = 0;
                } else {
                    char lastChar = keyword.charAt(keyword.length() - 1);
                    //kiểm tra xem lastChar có phải số hay không(0-9)
                    if (Character.isDigit(lastChar)) {

                        //Character.getNumericValue(lastChar) chuyển kí tự số '0' - '9 thành số tương ứng'
                        partition = Character.getNumericValue(lastChar) % 3;

                    //Character.isLetter(lastChar) → kiểm tra xem lastChar có phải là chữ cái (a–z, A–Z) hay không.
                    } else if (Character.isLetter(lastChar)) {
                        lastChar = Character.toLowerCase(lastChar);

//                  lastChar - 'a' + 1 → xác định vị trí chữ cái trong bảng alphabet:
//                  'a' - 'a' + 1 = 1,
//                  'b' - 'a' + 1 = 2
                        int pos = lastChar - 'a' + 1;

                        partition = pos % 3;
                    } else {
                        partition = 0; // ký tự đặc biệt → default partition
                    }
                }
            } else {
                Long productId = object.getProductId();
                if (productId == null) {
                    partition = 0;
                } else {
                    partition = (int) (productId % 3);
                }
            }
            kafkaTemplate.send(topic, partition, null, message);
            log.info("send message to topic `{}` partition `{}`", topic, partition);

        } catch (Exception e) {
            log.error("Error sending message to Kafka: {}", e.getMessage(), e);
        }
    }
}
