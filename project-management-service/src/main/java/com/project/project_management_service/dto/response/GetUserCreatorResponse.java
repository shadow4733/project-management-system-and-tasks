package com.project.project_management_service.dto.response;

import com.project.project_management_service.dto.additional.GetUserCreatorDto;

public record GetUserCreatorResponse(
        GetUserCreatorDto user
) {
}
