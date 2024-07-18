package com.project.user_service.dto.request;

public record AuthenticationRequest(
        String username,
        String password
) {
}
