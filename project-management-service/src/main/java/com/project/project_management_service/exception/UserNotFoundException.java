package com.project.project_management_service.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("User not found.");
    }
}
