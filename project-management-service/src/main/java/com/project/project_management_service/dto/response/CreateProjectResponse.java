package com.project.project_management_service.dto.response;

import com.project.project_management_service.model.enums.Profession;

import java.util.Set;
import java.util.UUID;

public record CreateProjectResponse(
        UUID projectId,
        UUID creatorId,
        String projectName,
        String projectDescription
) {
}
