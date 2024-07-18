package com.project.user_service.exception;

public class PasswordIsIncorrectException extends RuntimeException {
    public PasswordIsIncorrectException(){
        super("The password is incorrect");
    }
}
