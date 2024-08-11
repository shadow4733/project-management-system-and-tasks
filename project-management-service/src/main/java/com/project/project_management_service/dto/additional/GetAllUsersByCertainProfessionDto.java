package com.project.project_management_service.dto.additional;

import java.util.UUID;

public record GetAllUsersByCertainProfessionDto(
        UUID userId,
        String username
) {
}
