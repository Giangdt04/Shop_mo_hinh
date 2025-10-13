package com.example.shopmohinh.util;

import jakarta.servlet.http.HttpServletRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClientIpUtils {
    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip != null && !ip.isEmpty()) {
            // Nếu đi qua nhiều proxy, lấy IP đầu tiên
            ip = ip.split(",")[0].trim();
        } else {
            ip = request.getRemoteAddr();
        }

        // Nếu IP là localhost, lấy IP LAN của máy
        if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
            try {
                InetAddress inetAddress = InetAddress.getLocalHost();
                ip = inetAddress.getHostAddress();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }

        return ip;
    }
}
