package com.project.user_service.dto.request;

public record UpdatePasswordRequest(
        String username,
        String oldPassword,
        String newPassword
) {
}
