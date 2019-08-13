package com.example.service.ex;

public class UpdateUserInfoFailException extends RuntimeException {
    public UpdateUserInfoFailException() {
    }

    public UpdateUserInfoFailException(String message) {
        super(message);
    }

    public UpdateUserInfoFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateUserInfoFailException(Throwable cause) {
        super(cause);
    }

    public UpdateUserInfoFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
