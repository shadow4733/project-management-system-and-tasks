package com.project.project_management_service.dto.request;

public record CreateProjectRequest(
        String projectName,
        String projectDescription
) {
}
