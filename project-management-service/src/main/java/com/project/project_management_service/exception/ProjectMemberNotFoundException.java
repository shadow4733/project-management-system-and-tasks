package com.project.project_management_service.exception;

public class ProjectMemberNotFoundException extends RuntimeException{
    public ProjectMemberNotFoundException() {
        super("Project member not found!");
    }
}
