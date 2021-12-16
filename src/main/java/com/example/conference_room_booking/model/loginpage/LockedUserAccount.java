package com.example.conference_room_booking.model.loginpage;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class LockedUserAccount {

    @Id
    private String emailId;
    private boolean isAccountLocked;
    private Date lockTime;
    private int failedAttempt;

    public LockedUserAccount() {
    }

    public LockedUserAccount(String emailId, boolean isAccountLocked, Date lockTime, int failedAttempt) {
        this.emailId = emailId;
        this.isAccountLocked = isAccountLocked;
        this.lockTime = lockTime;
        this.failedAttempt = failedAttempt;
    }

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
        return "LockedUserAccount{" +
                "emailId='" + emailId + '\'' +
                ", isAccountLocked=" + isAccountLocked +
                ", lockTime=" + lockTime +
                ", failedAttempt=" + failedAttempt +
                '}';
    }
}
