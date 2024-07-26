package com.project.project_management_service.exception;

public class ProjectNameAlreadyExistsException extends RuntimeException {
    public ProjectNameAlreadyExistsException(String projectName) {
        super("Project with name " + projectName + " already exists!");
    }
}
