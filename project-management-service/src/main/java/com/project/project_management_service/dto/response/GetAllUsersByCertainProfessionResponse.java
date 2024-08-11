package com.project.project_management_service.dto.response;

import com.project.project_management_service.dto.additional.GetAllUsersByCertainProfessionDto;

import java.util.List;

public record GetAllUsersByCertainProfessionResponse(
        List<GetAllUsersByCertainProfessionDto> users
) {
}
