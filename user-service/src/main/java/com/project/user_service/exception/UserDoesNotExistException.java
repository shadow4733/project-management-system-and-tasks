package com.project.user_service.exception;

public class UserDoesNotExistException extends RuntimeException {
    public UserDoesNotExistException(){
        super("User Does Not exist");
    }
}
