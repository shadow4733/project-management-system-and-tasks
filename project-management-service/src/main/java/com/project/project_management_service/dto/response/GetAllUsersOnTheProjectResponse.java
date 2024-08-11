package com.project.project_management_service.dto.response;

import com.project.project_management_service.dto.additional.GetAllUserDto;

import java.util.List;

public record GetAllUsersOnTheProjectResponse(
        List<GetAllUserDto> users
) {
}
