package com.project.project_management_service.exception;

import java.util.UUID;

public class ProjectNotFoundException extends RuntimeException{
    public ProjectNotFoundException() {
        super("Project not found.");
    }
}
