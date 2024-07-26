package com.project.project_management_service.dto.request;

import java.util.UUID;

public record CreateProjectRequest(
        UUID creatorId,
        String projectName,
        String projectDescription
) {
}