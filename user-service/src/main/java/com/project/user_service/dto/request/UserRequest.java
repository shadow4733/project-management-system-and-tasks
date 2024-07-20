package com.project.user_service.dto.request;

public record UserRequest(
        String username,
        String email,
        String password,
        String passwordConfirm
) {
}
