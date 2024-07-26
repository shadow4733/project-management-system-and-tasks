package com.project.project_management_service.service;

import com.project.project_management_service.dto.request.AddAUserToTheProjectRequest;
import com.project.project_management_service.dto.request.CreateProjectRequest;
import com.project.project_management_service.dto.response.AddAUserToTheProjectResponse;
import com.project.project_management_service.dto.response.CreateProjectResponse;

public interface ProjectService {
    CreateProjectResponse createProject(CreateProjectRequest request);
    AddAUserToTheProjectResponse addUserToProject(AddAUserToTheProjectRequest request);
}
