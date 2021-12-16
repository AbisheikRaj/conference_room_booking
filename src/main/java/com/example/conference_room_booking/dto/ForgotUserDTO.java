package com.example.conference_room_booking.dto;


public class ForgotUserDTO {

    private String emailId;
    private String securityAnswer;
    private String securityQuestion;
    private boolean exceptionStatus;
    private String exceptionMessage;

    public ForgotUserDTO() {
    }

    public ForgotUserDTO(String emailId, String securityAnswer, String securityQuestion) {
        this.emailId = emailId;
        this.securityAnswer = securityAnswer;
        this.securityQuestion = securityQuestion;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getAnswer() {
        return securityAnswer;
    }

    public void setAnswer(String answer) {
        this.securityAnswer = answer;
    }

    public boolean getExceptionStatus() {
        return exceptionStatus;
    }

    public void setExceptionStatus(boolean exceptionStatus) {
        this.exceptionStatus = exceptionStatus;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

}
