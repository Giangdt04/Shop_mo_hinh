package com.example.shopmohinh.service;

import com.example.shopmohinh.entity.PasswordResetTokens;
import com.example.shopmohinh.entity.User;
import com.example.shopmohinh.repository.PasswordResetTokensRepository;
import com.example.shopmohinh.repository.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
@Service
public class PasswordResetService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokensRepository tokenRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String generateResetToken(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = UUID.randomUUID().toString();
        PasswordResetTokens resetToken = new PasswordResetTokens();
        resetToken.setToken(token);
        resetToken.setUser(user);
        resetToken.setExpiryDate(LocalDateTime.now().plusHours(1));

        tokenRepository.save(resetToken);
        sendResetEmail(user.getEmail(), token);

        return "Reset password link sent to your email!";
    }

    private void sendResetEmail(String email, String token) {
        String resetLink = "Mã xác nhận của bạn là: " + token;
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(email);
            helper.setSubject("Reset Your Password");
            helper.setText("Click the link to reset your password: " + resetLink, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email");
        }
    }

    public String resetPassword(String token, String newPassword) {
        PasswordResetTokens resetToken = tokenRepository.findByToken(token);

        if (resetToken == null || resetToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            return "Invalid or expired token!";
        }

        User user = resetToken.getUser();

        // Chỉ cập nhật mật khẩu, không thay đổi thông tin khác
        user.setPass(passwordEncoder.encode(newPassword));
        userRepository.save(user);

        // Xóa token sau khi sử dụng
        tokenRepository.delete(resetToken);

        return "Password reset successful!";
    }

}
