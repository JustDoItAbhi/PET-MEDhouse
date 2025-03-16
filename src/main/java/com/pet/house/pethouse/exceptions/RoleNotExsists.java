package com.pet.house.pethouse.exceptions;

public class RoleNotExsists extends RuntimeException{
    public RoleNotExsists() {
    }

    public RoleNotExsists(String message) {
        super(message);
    }

    public RoleNotExsists(String message, Throwable cause) {
        super(message, cause);
    }

    public RoleNotExsists(Throwable cause) {
        super(cause);
    }

    public RoleNotExsists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
