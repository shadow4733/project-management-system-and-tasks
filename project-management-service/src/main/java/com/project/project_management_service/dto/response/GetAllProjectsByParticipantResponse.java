package com.project.project_management_service.dto.response;

import com.project.project_management_service.model.Project;
import java.util.List;

public record GetAllProjectsByParticipantResponse(
        List<Project> projects
) {
}