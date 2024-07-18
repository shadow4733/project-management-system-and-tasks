package com.project.user_service.serviceImpl;

import com.project.user_service.model.User;
import com.project.user_service.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    public void sendEmailVerificationToken(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Email verification");
        message.setText("To verify your email, please click the link below:\n"
                + "http://localhost:8080/api/v1/users/verify-email?token=" + user.getEmailToken());
        mailSender.send(message);
    }
}
