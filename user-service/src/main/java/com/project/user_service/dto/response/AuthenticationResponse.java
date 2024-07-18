package com.project.user_service.dto.response;

import java.util.UUID;

public record AuthenticationResponse(
        UUID userId,
        String status
) {
}
