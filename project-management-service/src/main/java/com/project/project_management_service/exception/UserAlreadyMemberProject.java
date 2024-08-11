package com.project.project_management_service.exception;

public class UserAlreadyMemberProject extends RuntimeException{
    public UserAlreadyMemberProject() {
        super("User is already a member of the project");
    }
}
