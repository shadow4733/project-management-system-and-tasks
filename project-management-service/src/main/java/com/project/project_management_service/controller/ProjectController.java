package com.project.project_management_service.controller;

import com.project.project_management_service.dto.request.*;
import com.project.project_management_service.dto.response.*;
import com.project.project_management_service.model.enums.Profession;
import com.project.project_management_service.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v2/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/createProject")
    public CreateProjectResponse createProject(@RequestBody CreateProjectRequest request) {
        return projectService.createProject(request);
    }

    @PutMapping("/updateProject")
    public UpdateProjectResponse updateProject(@RequestBody UpdateProjectRequest request) {
        return projectService.updateProject(request);
    }

    @GetMapping("/getProjectInfoById/{id}")
    public ResponseEntity<GetProjectInfoByIdResponse> getProjectInfoById(@PathVariable UUID id) {
        GetProjectInfoByIdRequest request = new GetProjectInfoByIdRequest(id);
        GetProjectInfoByIdResponse response = projectService.getProjectInfoById(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/addUserToProject/{projectId}/users")
    public AddUserToTheProjectResponse addUserToProject(@RequestBody AddUserToTheProjectRequest request) {
        return projectService.addUserToProject(request);
    }

    @PostMapping("/addTaskToProject")
    public AddTaskToTheProjectResponse addTaskToProject(@RequestBody AddTaskToTheProjectRequest request) {
        return projectService.addTaskToProject(request);
    }

    @DeleteMapping("/deleteUserFromProject/{projectId}/users/{userId}")
    public DeleteUserFromProjectResponse deleteUserFromProject(@PathVariable UUID projectId, @PathVariable UUID userId) {
        return projectService.deleteUserFromProject(new DeleteUserFromProjectRequest(projectId, userId));
    }

    @GetMapping("/getAllUsersByCertainProfession/users/profession")
    public GetAllUsersByCertainProfessionResponse getAllUsersByCertainProfession(@RequestParam Profession profession) {
        return projectService.getAllUsersByCertainProfessionOnTheProject(new GetAllUsersByCertainProfessionRequest(profession));
    }

    @GetMapping("/getAllUsersOnTheProject/{projectId}/users")
    public GetAllUsersOnTheProjectResponse getAllUsersOnTheProject(@PathVariable UUID projectId) {
        return projectService.getAllUsersOnTheProject(new GetAllUsersOnTheProjectRequest(projectId));
    }

    @GetMapping("/getUserCreator/{projectId}/creator")
    public GetUserCreatorResponse getUserCreator(@PathVariable UUID projectId) {
        return projectService.getUserCreator(new GetUserCreatorRequest(projectId));
    }
}