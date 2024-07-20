package com.project.project_management_service.dto.response;

public record CreateProjectResponse(
        String projectName,
        String projectDescription,
        String status
) {
}
