package com.project.project_management_service.serviceImpl;

import com.project.project_management_service.dto.additional.GetAllUserDto;
import com.project.project_management_service.dto.additional.GetAllUsersByCertainProfessionDto;
import com.project.project_management_service.dto.additional.GetUserCreatorDto;
import com.project.project_management_service.dto.request.*;
import com.project.project_management_service.dto.response.*;
import com.project.project_management_service.exception.ProjectMemberNotFoundException;
import com.project.project_management_service.exception.ProjectNotFoundException;
import com.project.project_management_service.exception.UserAlreadyMemberProject;
import com.project.project_management_service.exception.UserNotFoundException;
import com.project.project_management_service.model.Project;
import com.project.project_management_service.model.ProjectMember;
import com.project.project_management_service.model.VerifiedUser;
import com.project.project_management_service.model.enums.Profession;
import com.project.project_management_service.repository.ProjectMemberRepository;
import com.project.project_management_service.repository.ProjectRepository;
import com.project.project_management_service.repository.VerifiedUserRepository;
import com.project.project_management_service.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final VerifiedUserRepository verifiedUserRepository;
    private final ProjectMemberRepository projectMemberRepository;

    Logger logger = Logger.getLogger(ProjectServiceImpl.class.getName());

    @Override
    public CreateProjectResponse createProject(CreateProjectRequest request) {
        VerifiedUser creator = verifiedUserRepository.findById(request.creatorId())
                .orElseThrow(() -> new UserNotFoundException());

        creator.setProfession(Profession.CREATOR_OF_THE_PROJECT);
        verifiedUserRepository.save(creator);

        Project project = new Project();
        project.setProjectId(UUID.randomUUID());
        project.setCreator(creator);
        project.setCreatorUsername(request.creatorUsername());
        project.setProjectName(request.projectName());
        project.setProjectDescription(request.projectDescription());

        Project savedProject = projectRepository.save(project);

        ProjectMember projectMember = new ProjectMember();
        projectMember.setProject(savedProject); // Use the saved project here
        projectMember.setUser(creator);
        projectMember.setUsername(creator.getUsername());
        projectMember.setProfession(Profession.CREATOR_OF_THE_PROJECT);

        Set<ProjectMember> projectMembers = new HashSet<>();
        projectMembers.add(projectMember);

        savedProject.setProjectMembers(projectMembers);

        // Save the ProjectMember to the database
        projectMemberRepository.save(projectMember);

        logger.info("Project created with id: " + savedProject.getProjectId());

        return new CreateProjectResponse(
                savedProject.getProjectId(),
                savedProject.getCreator().getUserId(),
                savedProject.getProjectName(),
                savedProject.getProjectDescription(),
                "success"
        );
    }

    @Override
    public UpdateProjectResponse updateProject(UpdateProjectRequest request) {
        return null;
    }

    @Override
    public GetProjectInfoByIdResponse getProjectById(GetProjectInfoByIdRequest request) {
        return null;
    }

    @Override
    public AddUserToTheProjectResponse addUserToProject(AddUserToTheProjectRequest request) {
        Project project = projectRepository.findById(request.projectId())
                .orElseThrow(() -> new ProjectNotFoundException());

        VerifiedUser user = verifiedUserRepository.findById(request.userId())
                .orElseThrow(() -> new UserNotFoundException());

        boolean isUserAlreadyMember = project.getProjectMembers().stream()
                .anyMatch(member -> member.getUser().getUserId().equals(user.getUserId()));
        if (isUserAlreadyMember) {
            throw new UserAlreadyMemberProject();
        }

        ProjectMember projectMember = new ProjectMember();
        projectMember.setProject(project);
        projectMember.setUser(user);
        projectMember.setUsername(user.getUsername());
        projectMember.setProfession(request.profession());

        project.getProjectMembers().add(projectMember);
        user.getProjectMembers().add(projectMember);

        projectMemberRepository.save(projectMember);

        logger.info("User " + user.getUsername() + " added to project " + project.getProjectName());

        return new AddUserToTheProjectResponse(
                user.getUsername(),
                project.getProjectName(),
                "success"
        );
    }

    @Override
    public DeleteUserFromProjectResponse deleteUserFromProject(DeleteUserFromProjectRequest request) {
        Project project = projectRepository.findById(request.projectId())
                .orElseThrow(() -> new ProjectNotFoundException());
        VerifiedUser user = verifiedUserRepository.findById(request.userId())
                .orElseThrow(() -> new UserNotFoundException());

        ProjectMember projectMember = projectMemberRepository.findByProjectAndUser(project, user)
                .orElseThrow(() -> new ProjectMemberNotFoundException());

        project.getProjectMembers().remove(projectMember);
        user.getProjectMembers().remove(projectMember);

        projectMemberRepository.delete(projectMember);

        logger.info("User " + user.getUsername() + " removed from project " + project.getProjectName());

        return new DeleteUserFromProjectResponse("Success");
    }

    @Override
    public GetAllUsersByCertainProfessionResponse getAllUsersByCertainProfessionOnTheProject(GetAllUsersByCertainProfessionRequest request) {
        List<VerifiedUser> users = verifiedUserRepository.findAllByProfession(request.profession());

        logger.info("Found " + users.size() + " users with profession " + request.profession());

        List<GetAllUsersByCertainProfessionDto> userList = new ArrayList<>();
        for (VerifiedUser user : users) {
            GetAllUsersByCertainProfessionDto userDto = new GetAllUsersByCertainProfessionDto(
                    user.getUserId(),
                    user.getUsername()
            );
            userList.add(userDto);
        }

        return new GetAllUsersByCertainProfessionResponse(userList);
    }

    @Override
    public GetAllUsersOnTheProjectResponse getAllUsersOnTheProject(GetAllUsersOnTheProjectRequest request) {
        Project project = projectRepository.findById(request.projectId())
                .orElseThrow(() -> new ProjectNotFoundException());

        Set<ProjectMember> users = project.getProjectMembers();

        logger.info("Found " + users.size() + " users on project " + project.getProjectName());

        List<GetAllUserDto> userList = new ArrayList<>();
        for (ProjectMember projectMember : users) {
            GetAllUserDto userDto = new GetAllUserDto(
                    projectMember.getUser().getUserId(),
                    projectMember.getUser().getUsername(),
                    projectMember.getProfession()
            );
            userList.add(userDto);
        }

        return new GetAllUsersOnTheProjectResponse(userList);
    }

    @Override
    public GetUserCreatorResponse getUserCreator(GetUserCreatorRequest request) {
        Project project = projectRepository.findById(request.projectId())
                .orElseThrow(() -> new ProjectNotFoundException());

        VerifiedUser creator = project.getCreator();

        logger.info("Found creator " + creator.getUsername() + " for project " + project.getProjectName());

        GetUserCreatorDto creatorDto = new GetUserCreatorDto(
                creator.getUserId(),
                creator.getUsername()
        );

        return new GetUserCreatorResponse(creatorDto);
    }

    @Override
    public GetAllProjectsByCreatorResponse getAllProjectsByCreator(GetAllProjectsByCreatorRequest request) {
        return null;
    }

    @Override
    public GetAllProjectsByParticipantResponse getAllProjectsByParticipant(GetAllProjectsByParticipantRequest request) {
        return null;
    }

}