package com.liubimba.backend.exception;

public class UserMailExistsException extends Exception {
    public UserMailExistsException(String message) {
        super(message);
    }

    public UserMailExistsException() {
        super();
    }
}
