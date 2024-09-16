package com.project.project_management_service.dto.request;

import com.project.project_management_service.model.enums.Profession;

import java.util.UUID;

public record AddTaskToTheProjectResponse(
        UUID taskId,
        String TaskName,
        String TaskDescription,
        String TaskStatus,
        String TaskPriority,
        UUID projectId,
        String projectName,
        UUID userId,
        String username,
        String profession
) {
}
