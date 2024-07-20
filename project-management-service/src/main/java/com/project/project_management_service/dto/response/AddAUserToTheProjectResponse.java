package com.project.project_management_service.dto.response;

public record AddAUserToTheProjectResponse(
        String username,
        String projectName,
        String status
) {
}
