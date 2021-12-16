package com.example.conference_room_booking.service;

import com.example.conference_room_booking.dao.LockUserDAO;
import com.example.conference_room_booking.model.loginpage.LockedUserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LockUserServiceImpl implements LockUserService {

    @Autowired
    private LockUserDAO lockUserDAO;

    @Override
    public void createLockUserAccount(String emailId) {
        lockUserDAO.createLockUserAccount(emailId);
    }

    @Override
    public LockedUserAccount updateFailedAttempt(String emailId) {
        return lockUserDAO.updateFailedAttempt(emailId);
    }

    @Override
    public LockedUserAccount unlockUserAccount(String emailId) {
        return lockUserDAO.unlockUserAccount(emailId);
    }

    @Override
    public boolean lockUserAccount(LockedUserAccount userAccount) {
        return lockUserDAO.lockUserAccount(userAccount);
    }

}
