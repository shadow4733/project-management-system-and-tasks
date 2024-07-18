package com.project.user_service.exception;

public class WeakPasswordException extends RuntimeException {
    public WeakPasswordException(String password) {
        super("The password is too weak: " + password);
    }
}
