package com.project.project_management_service.dto.response;

import com.project.project_management_service.model.enums.Profession;

import java.util.UUID;

public record AddTaskToTheProjectRequest(
    String taskName,
    String taskDescription,
    String taskStatus,
    String taskPriority,
    UUID projectId,
    String projectName,
    UUID userId,
    String username,
    String profession
) {
}
