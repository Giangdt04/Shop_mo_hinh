package com.example.shopmohinh.controller;

import com.example.shopmohinh.configuration.VnpayConfig;
import com.example.shopmohinh.dto.request.PaymentResquest;
import com.example.shopmohinh.service.VnpayService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ObjectInputFilter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.example.shopmohinh.configuration.VnpayConfig.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private VnpayService vnpayService;

    @PostMapping("/submitOrder")
    public ResponseEntity<String> submitOrder(@RequestParam("amount") int orderTotal,
                                              @RequestParam("orderInfo") String orderInfo,
                                              HttpServletRequest request) {
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String vnpayUrl = vnpayService.createOrder(orderTotal, orderInfo, baseUrl);
        return ResponseEntity.ok(vnpayUrl); // Trả về URL trực tiếp
    }

    @GetMapping("/vnpay-payment")
    public ResponseEntity<Map<String, Object>> handlePaymentResponse(HttpServletRequest request) {
        int paymentStatus = vnpayService.orderReturn(request);

        Map<String, Object> response = new HashMap<>();
        response.put("paymentStatus", paymentStatus == 1 ? "success" : "fail");
        response.put("orderId", request.getParameter("vnp_OrderInfo"));
        response.put("totalPrice", request.getParameter("vnp_Amount"));
        response.put("paymentTime", request.getParameter("vnp_PayDate"));
        response.put("transactionId", request.getParameter("vnp_TransactionNo"));

        return ResponseEntity.ok(response);
    }
}
