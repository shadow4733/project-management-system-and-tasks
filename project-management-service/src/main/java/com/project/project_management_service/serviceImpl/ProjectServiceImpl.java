package com.project.project_management_service.serviceImpl;

import com.project.project_management_service.dto.request.AddAUserToTheProjectRequest;
import com.project.project_management_service.dto.request.CreateProjectRequest;
import com.project.project_management_service.dto.response.AddAUserToTheProjectResponse;
import com.project.project_management_service.dto.response.CreateProjectResponse;
import com.project.project_management_service.exception.ProjectNotFoundException;
import com.project.project_management_service.exception.UserNotFoundException;
import com.project.project_management_service.model.Project;
import com.project.project_management_service.model.VerifiedUser;
import com.project.project_management_service.repository.ProjectRepository;
import com.project.project_management_service.repository.VerifiedUserRepository;
import com.project.project_management_service.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.UUID;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final VerifiedUserRepository verifiedUserRepository;

    Logger logger = Logger.getLogger(ProjectServiceImpl.class.getName());

    @Override
    public CreateProjectResponse createProject(CreateProjectRequest request) {
        VerifiedUser creator = verifiedUserRepository.findById(request.creatorId())
                .orElseThrow(() -> new UserNotFoundException("User with id " + request.creatorId() + " not found"));

        Project project = new Project();
        project.setProjectId(UUID.randomUUID());
        project.setCreator(creator);
        project.setProjectName(request.projectName());
        project.setProjectDescription(request.projectDescription());
        project.setProjectMembers(new HashSet<>());

        Project savedProject = projectRepository.save(project);

        return new CreateProjectResponse(
                savedProject.getProjectId(),
                savedProject.getCreator().getUserId(),
                savedProject.getProjectName(),
                savedProject.getProjectDescription(),
                "success"
        );
    }

    @Override
    public AddAUserToTheProjectResponse addUserToProject(AddAUserToTheProjectRequest request) {
        Project project = projectRepository.findById(request.projectId())
                .orElseThrow(() -> new ProjectNotFoundException());

        VerifiedUser user = verifiedUserRepository.findById(request.userId())
                .orElseThrow(() -> new UserNotFoundException("User with id " + request.userId() + " not found"));

        user.setProfession(request.profession());

        project.getProjectMembers().add(user);
        user.getMemberProjects().add(project);

        projectRepository.save(project);
        verifiedUserRepository.save(user);

        return new AddAUserToTheProjectResponse(
                user.getUsername(),
                project.getProjectName(),
                "success"
        );
    }

}