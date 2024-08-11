package com.project.project_management_service.dto.request;

import com.project.project_management_service.model.enums.Profession;

public record GetAllUsersByCertainProfessionRequest(
        Profession profession
) {
}
