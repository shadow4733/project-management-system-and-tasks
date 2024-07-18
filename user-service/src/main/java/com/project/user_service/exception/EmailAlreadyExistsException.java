package com.project.user_service.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email){
        super("Email " + email + " already exists");
    }
}
