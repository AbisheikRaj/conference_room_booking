package com.example.conference_room_booking.exception;

public class EmailIdNotFoundException extends Exception {

    private final String exceptionMessage;

    public EmailIdNotFoundException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
