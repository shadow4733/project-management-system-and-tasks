package com.project.project_management_service.exception;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException() {
        super("Project name cannot be null or empty");
    }
}
