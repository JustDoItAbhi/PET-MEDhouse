package com.pet.house.pethouse.exceptions;

public class OwnerNotExsitsException extends RuntimeException{
    public OwnerNotExsitsException() {
    }

    public OwnerNotExsitsException(String message) {
        super(message);
    }

    public OwnerNotExsitsException(String message, Throwable cause) {
        super(message, cause);
    }

    public OwnerNotExsitsException(Throwable cause) {
        super(cause);
    }

    public OwnerNotExsitsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
