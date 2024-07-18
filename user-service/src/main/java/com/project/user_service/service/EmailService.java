package com.project.user_service.service;

import com.project.user_service.model.User;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendEmailVerificationToken(User user);
}
