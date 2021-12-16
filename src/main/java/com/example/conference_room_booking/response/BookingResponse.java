package com.example.conference_room_booking.response;

public class BookingResponse {

    private String message;

    public BookingResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
