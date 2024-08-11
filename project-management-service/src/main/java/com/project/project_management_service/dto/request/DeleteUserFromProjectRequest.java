package com.project.project_management_service.dto.request;

import java.util.UUID;

public record DeleteUserFromProjectRequest(
        UUID projectId,
        UUID userId
) {
}
