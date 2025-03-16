package com.pet.house.pethouse.exceptions;

public class AppointmentAlreadyBooked extends RuntimeException{
    public AppointmentAlreadyBooked() {
    }

    public AppointmentAlreadyBooked(String message) {
        super(message);
    }

    public AppointmentAlreadyBooked(String message, Throwable cause) {
        super(message, cause);
    }

    public AppointmentAlreadyBooked(Throwable cause) {
        super(cause);
    }

    public AppointmentAlreadyBooked(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
