package com.example.service.ex;

public class UserRegisterFailedException extends RuntimeException {
    public UserRegisterFailedException() {
    }

    public UserRegisterFailedException(String message) {
        super(message);
    }

    public UserRegisterFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserRegisterFailedException(Throwable cause) {
        super(cause);
    }

    public UserRegisterFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
