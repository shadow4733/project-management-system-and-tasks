package com.project.project_management_service.controller;

import com.project.project_management_service.dto.request.AddAUserToTheProjectRequest;
import com.project.project_management_service.dto.request.CreateProjectRequest;
import com.project.project_management_service.dto.response.AddAUserToTheProjectResponse;
import com.project.project_management_service.dto.response.CreateProjectResponse;
import com.project.project_management_service.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v2/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<CreateProjectResponse> createProject(@RequestBody CreateProjectRequest request) {
        CreateProjectResponse response = projectService.createProject(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{projectId}/users")
    public ResponseEntity<AddAUserToTheProjectResponse> addAUserToProject(@RequestBody AddAUserToTheProjectRequest request) {
        AddAUserToTheProjectResponse response = projectService.addUserToProject(request);
        return ResponseEntity.ok(response);
    }

}