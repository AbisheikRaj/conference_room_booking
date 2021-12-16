package com.example.conference_room_booking.service;

import com.example.conference_room_booking.model.loginpage.LockedUserAccount;
import org.springframework.stereotype.Service;

@Service
public interface LockUserService {
    void createLockUserAccount(String emailId);
    LockedUserAccount updateFailedAttempt(String emailId);
    LockedUserAccount unlockUserAccount(String emailId);
    boolean lockUserAccount(LockedUserAccount userAccount);
}
