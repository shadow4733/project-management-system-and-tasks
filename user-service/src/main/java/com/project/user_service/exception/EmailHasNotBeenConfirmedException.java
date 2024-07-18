package com.project.user_service.exception;

public class EmailHasNotBeenConfirmedException extends RuntimeException {
    public EmailHasNotBeenConfirmedException(){
        super("Email has not been confirmed");
    }
}
