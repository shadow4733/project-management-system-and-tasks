package com.project.project_management_service.serviceImpl;

import com.project.project_management_service.dto.request.AddAUserToTheProjectRequest;
import com.project.project_management_service.dto.request.CreateProjectRequest;
import com.project.project_management_service.dto.response.AddAUserToTheProjectResponse;
import com.project.project_management_service.dto.response.CreateProjectResponse;
import com.project.project_management_service.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    Logger logger = Logger.getLogger(ProjectServiceImpl.class.getName());

    @Override
    public CreateProjectResponse createProject(CreateProjectRequest request) {
        logger.info("Project created successfully");
        return null;
    }

    @Override
    public AddAUserToTheProjectResponse addAUserToProject(AddAUserToTheProjectRequest request) {
        logger.info("User added to the project successfully");
        return null;
    }
}
