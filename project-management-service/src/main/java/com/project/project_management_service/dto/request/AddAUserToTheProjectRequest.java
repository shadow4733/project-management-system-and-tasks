package com.project.project_management_service.dto.request;

import java.util.UUID;

public record AddAUserToTheProjectRequest(
    UUID userId,
    UUID projectId,
    String username,
    String projectName
) {
}
