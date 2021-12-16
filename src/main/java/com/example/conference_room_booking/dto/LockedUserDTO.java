package com.example.conference_room_booking.dto;

import java.util.Date;

public class LockedUserDTO {

    private String emailId;
    private boolean isAccountLocked;
    private Date lockTime;
    private int failedAttempt;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public boolean isAccountLocked() {
        return isAccountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        isAccountLocked = accountLocked;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    public int getFailedAttempt() {
        return failedAttempt;
    }

    public void setFailedAttempt(int failedAttempt) {
        this.failedAttempt = failedAttempt;
    }

    @Override
    public String toString() {
        return "LockedUserDTO{" +
                "emailId='" + emailId + '\'' +
                ", isAccountLocked=" + isAccountLocked +
                ", lockTime=" + lockTime +
                ", failedAttempt=" + failedAttempt +
                '}';
    }
}
