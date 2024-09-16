package com.project.project_management_service.dto.response;

import com.project.project_management_service.model.Project;

import java.util.UUID;

public record GetProjectInfoByIdResponse(
        UUID projectId,
        String creatorUsername,
        String projectName,
        String projectDescription


) {
}