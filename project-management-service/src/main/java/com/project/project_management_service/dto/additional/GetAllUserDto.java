package com.project.project_management_service.dto.additional;

import com.project.project_management_service.model.enums.Profession;

import java.util.UUID;

public record GetAllUserDto(
        UUID userId,
        String username,
        Profession profession
) {
}
