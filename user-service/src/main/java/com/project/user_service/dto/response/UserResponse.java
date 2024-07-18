package com.project.user_service.dto.response;

import java.util.UUID;

public record UserResponse(
        UUID userId,
        String username

) {
}
