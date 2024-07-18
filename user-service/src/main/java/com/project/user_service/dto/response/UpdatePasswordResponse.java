package com.project.user_service.dto.response;

import java.util.UUID;

public record UpdatePasswordResponse(
        UUID userId,
        String status
) {
}
