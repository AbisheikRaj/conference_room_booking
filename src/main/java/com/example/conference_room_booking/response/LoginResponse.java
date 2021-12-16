package com.example.conference_room_booking.response;

public class LoginResponse {

    private boolean exceptionStatus;
    private String responseMessage;

    public LoginResponse() {
    }

    public LoginResponse(boolean exceptionStatus, String responseMessage) {
        this.exceptionStatus = exceptionStatus;
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
    public boolean getExceptionStatus() {
        return exceptionStatus;
    }

    public void setExceptionStatus(boolean responseStatus) {
        this.exceptionStatus = responseStatus;
    }

}
