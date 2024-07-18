package com.project.user_service.dto.request;

import java.util.UUID;

public record AddUserToTheProjectRequest(
        String username,
        UUID projectId
){}
