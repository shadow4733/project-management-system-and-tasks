package com.project.project_management_service.dto.request;

import com.project.project_management_service.model.enums.Profession;

import java.util.UUID;

public record AddUserToTheProjectRequest(
    UUID userId,
    UUID projectId,
    String username,
    String projectName,
    Profession profession
) {
}
