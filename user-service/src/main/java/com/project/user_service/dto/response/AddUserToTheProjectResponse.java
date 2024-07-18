package com.project.user_service.dto.response;

import java.util.UUID;

public record AddUserToTheProjectResponse(
        UUID userId,
        UUID projectId,
        String status
) {
}
