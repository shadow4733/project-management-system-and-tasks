package com.project.user_service.exception;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String username){
        super("Username with username " + username + " already exists");
    }
}
