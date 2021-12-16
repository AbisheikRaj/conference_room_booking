package com.example.conference_room_booking.exception;

public class DatabaseException extends Exception {

    private final String exceptionMessage;

    public DatabaseException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
