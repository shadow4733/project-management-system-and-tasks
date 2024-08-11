package com.project.project_management_service.service;

import com.project.project_management_service.dto.request.*;
import com.project.project_management_service.dto.response.*;

public interface ProjectService {
    CreateProjectResponse createProject(CreateProjectRequest request);
    UpdateProjectResponse updateProject(UpdateProjectRequest request);
    GetProjectInfoByIdResponse getProjectById(GetProjectInfoByIdRequest request);
    AddUserToTheProjectResponse addUserToProject(AddUserToTheProjectRequest request);
    DeleteUserFromProjectResponse deleteUserFromProject(DeleteUserFromProjectRequest request);
    GetAllUsersByCertainProfessionResponse getAllUsersByCertainProfessionOnTheProject(GetAllUsersByCertainProfessionRequest request);
    GetAllUsersOnTheProjectResponse getAllUsersOnTheProject(GetAllUsersOnTheProjectRequest request);
    GetUserCreatorResponse getUserCreator(GetUserCreatorRequest request);
    GetAllProjectsByCreatorResponse getAllProjectsByCreator(GetAllProjectsByCreatorRequest request);
    GetAllProjectsByParticipantResponse getAllProjectsByParticipant(GetAllProjectsByParticipantRequest request);
}