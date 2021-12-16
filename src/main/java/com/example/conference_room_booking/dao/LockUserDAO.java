package com.example.conference_room_booking.dao;

import com.example.conference_room_booking.model.loginpage.LockedUserAccount;
import com.example.conference_room_booking.repository.loginrepository.LockedUserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class LockUserDAO {

    private static final int MAX_FAILED_ATTEMPT = 3;
    private static final int LOCK_TIME = 60 * 1000;

    @Autowired
    private LockedUserAccountRepository lockedUserAccountRepository;

    public LockedUserAccount updateFailedAttempt(String emailId) {
        Optional<LockedUserAccount> lockedUserAccount = lockedUserAccountRepository.findByEmailId(emailId);
        if (lockedUserAccount.isPresent()) {
            LockedUserAccount userAccount = lockedUserAccount.get();
            userAccount.setFailedAttempt(userAccount.getFailedAttempt() + 1);
            return lockedUserAccountRepository.save(userAccount);

        }
        return new LockedUserAccount();
    }

    public void createLockUserAccount(String emailId) {
        lockedUserAccountRepository.save(new LockedUserAccount(emailId, false, null, 0));
    }

    public LockedUserAccount unlockUserAccount(String emailId) {
        Optional<LockedUserAccount> lockedUserAccount = lockedUserAccountRepository.findByEmailId(emailId);
        if (lockedUserAccount.isPresent()) {
            LockedUserAccount userAccount = lockedUserAccount.get();
            userAccount.setFailedAttempt(0);
            lockedUserAccountRepository.save(userAccount);
            if (userAccount.isAccountLocked() && userAccount.getLockTime().getTime() + LOCK_TIME <= System.currentTimeMillis()) {
                userAccount.setAccountLocked(false);
                return lockedUserAccountRepository.save(userAccount);
            }
        }
        return lockedUserAccount.orElseGet(LockedUserAccount::new);
    }

    public boolean lockUserAccount(LockedUserAccount userAccount) {
            if (!userAccount.isAccountLocked() && userAccount.getFailedAttempt() >= MAX_FAILED_ATTEMPT) {
                userAccount.setAccountLocked(true);
                userAccount.setLockTime(new Date());
                return true;
            }
        return false;
    }
}
