package com.pet.house.pethouse.exceptions;

public class VetNotFoundException extends RuntimeException{
    public VetNotFoundException() {
    }

    public VetNotFoundException(String message) {
        super(message);
    }

    public VetNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public VetNotFoundException(Throwable cause) {
        super(cause);
    }

    public VetNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
