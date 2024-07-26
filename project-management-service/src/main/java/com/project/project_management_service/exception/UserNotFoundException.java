package com.project.project_management_service.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String username) {
        super("User with username: " + username + " not found.");
    }
}
