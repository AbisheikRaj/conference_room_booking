package com.example.conference_room_booking.dao;

import com.example.conference_room_booking.exception.DatabaseException;
import com.example.conference_room_booking.exception.EmailIdNotFoundException;
import com.example.conference_room_booking.model.loginpage.*;
import com.example.conference_room_booking.repository.loginrepository.LockedUserAccountRepository;
import com.example.conference_room_booking.repository.loginrepository.LoginRepository;
import com.example.conference_room_booking.repository.loginrepository.PmoRepository;
import com.example.conference_room_booking.repository.loginrepository.SystemAdminRepository;
import com.example.conference_room_booking.response.LoginResponse;
import com.example.conference_room_booking.service.LockUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;


@Component
public class LoginUserDAO {

    @Autowired
    private LoginRepository repository;

    @Autowired
    private LockUserService lockUserService;

    @Autowired
    private LockedUserAccountRepository lockedUserAccountRepository;

    @Autowired
    private PmoRepository pmoRepository;

    @Autowired
    private SystemAdminRepository systemAdminRepository;

    private static final String LOCKED_USER_MESSAGE = "User is Locked";
    private static final String INVALID_CREDENTIAL = "Invalid Credential";

    public LoginResponse registerUser(RegisterUser registerUser) throws DatabaseException {
        try {
            if (!repository.existsByEmailId(registerUser.getEmailId())) {
                repository.save(registerUser);
                lockUserService.createLockUserAccount(registerUser.getEmailId());    // Lock User Account created
                return new LoginResponse(false,"Your details are successfully registered.");
            } else {
                return new LoginResponse(true, "Your email id's already Exist.");
            }
        } catch(Exception e) {
            e.printStackTrace();
            throw new DatabaseException("Database server is disconnected");
        }
    }

    public LoginResponse loginUser(LoginUser loginUser) throws DatabaseException {
        try {
            Optional<RegisterUser> registerUsers = repository.findByEmailId(loginUser.getEmailId());
            if (registerUsers.isPresent()) {
                return checkLockUser(registerUsers.get(), loginUser);
            }
            return new LoginResponse(true,"There is no account under this email id. So, Kindly create an account");
        } catch(Exception e) {
            e.printStackTrace();
            throw new DatabaseException("Database server is disconnected");
        }
    }

    public RegisterUser getSecurityAnswer(String emailId) throws EmailIdNotFoundException {
        Optional<RegisterUser> registerUser = repository.findByEmailId(emailId);
        return registerUser.orElseThrow(() -> new EmailIdNotFoundException("Email Id is not found"));
    }

    public LoginResponse updatePassword(String email, String password) throws DatabaseException {
        try {
            Optional<RegisterUser> registerUser = repository.findByEmailId(email);
            if (registerUser.isPresent()) {
                RegisterUser updateRegisterUser = registerUser.get();
                updateRegisterUser.setPassword(password);
                repository.save(updateRegisterUser);
            }
        } catch(Exception e) {
            throw new DatabaseException("Database Server is disconnected");
        }
        return new LoginResponse(false, "Your password has been reset.");
    }

    public LoginResponse checkLockUser(RegisterUser registerUsers, LoginUser loginUser) {
        if (registerUsers.isAccountEnabled()) {
            if (registerUsers.getPassword().equals(loginUser.getPassword())) {
                lockUserService.unlockUserAccount(registerUsers.getEmailId());
                return new LoginResponse(false, registerUsers.getRole());
            } else {
                LockedUserAccount userAccount = lockUserService.updateFailedAttempt(registerUsers.getEmailId());
                if(lockUserService.lockUserAccount(userAccount)) {
                    registerUsers.setAccountEnabled(false);
                    repository.save(registerUsers);
                    return new LoginResponse(true, LOCKED_USER_MESSAGE);
                }
                return new LoginResponse(true, INVALID_CREDENTIAL);
            }
        } else {
            LockedUserAccount lockedUserAccount = lockUserService.unlockUserAccount(registerUsers.getEmailId());
            return checkUnlockUser(lockedUserAccount, registerUsers, loginUser);
        }
    }

    public LoginResponse checkUnlockUser(LockedUserAccount lockedUserAccount, RegisterUser registerUsers, LoginUser loginUser) {
        if (!lockedUserAccount.isAccountLocked()) {
            if (registerUsers.getPassword().equals(loginUser.getPassword())) {
                registerUsers.setAccountEnabled(true);
                repository.save(registerUsers);
                lockedUserAccount.setLockTime(null);
                lockedUserAccount.setEmailId(registerUsers.getEmailId());
                lockedUserAccountRepository.save(lockedUserAccount);
                return new LoginResponse(false, "Your Account is unlocked. So, try to log in.");
            } else {
                LockedUserAccount userAccount = lockUserService.updateFailedAttempt(registerUsers.getEmailId());
                if (lockUserService.lockUserAccount(userAccount)) {
                    registerUsers.setAccountEnabled(false);
                    repository.save(registerUsers);
                    return new LoginResponse(true, LOCKED_USER_MESSAGE);
                }
                return new LoginResponse(true, INVALID_CREDENTIAL);
            }
        }

        return new LoginResponse(true, LOCKED_USER_MESSAGE);
    }

    // PMO and System Administrator

    public LoginResponse pmo(String emailId, String password) {
        Optional<PMO> pmo = pmoRepository.findByEmailId(emailId);
        if (pmo.isPresent()) {
            if (pmo.get().getEmailId().equals(emailId) && pmo.get().getPassword().equals(password)) {
                return new LoginResponse(false, "Successfully Logged");
            } else {
                return new LoginResponse(true, INVALID_CREDENTIAL);
            }
        } else {
            return new LoginResponse(true, "There is no account under this email Id");
        }
    }

    public LoginResponse sa(String emailId, String password) {
        Optional<SystemAdministrator> systemAdministrator = systemAdminRepository.findByEmailId(emailId);
        if (systemAdministrator.isPresent()) {
            if (systemAdministrator.get().getEmailId().equals(emailId) && systemAdministrator.get().getPassword().equals(password)) {
                return new LoginResponse(false, "Successfully Logged");
            } else {
                return new LoginResponse(true, INVALID_CREDENTIAL);
            }
        } else {
            return new LoginResponse(true, "There is no account under this email Id");
        }
    }

}
