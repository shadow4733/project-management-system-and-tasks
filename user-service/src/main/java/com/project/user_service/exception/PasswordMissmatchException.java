package com.project.user_service.exception;

public class PasswordMissmatchException extends RuntimeException {
    public PasswordMissmatchException(){
        super("Password and password confirm do not match");
    }
}
