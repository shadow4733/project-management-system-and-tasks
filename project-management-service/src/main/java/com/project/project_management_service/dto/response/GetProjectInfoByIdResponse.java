package com.project.project_management_service.dto.response;

import com.project.project_management_service.model.Project;

public record GetProjectInfoByIdResponse(
        Project project
) {
}