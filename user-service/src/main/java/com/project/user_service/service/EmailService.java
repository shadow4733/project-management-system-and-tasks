package com.project.user_service.service;

import com.project.user_service.model.User;

public interface EmailService {
    void sendEmailVerificationToken(User user);
}
