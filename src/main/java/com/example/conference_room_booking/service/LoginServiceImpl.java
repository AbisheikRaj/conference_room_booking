package com.example.conference_room_booking.service;

import com.example.conference_room_booking.dao.LoginUserDAO;
import com.example.conference_room_booking.dto.ForgotUserDTO;
import com.example.conference_room_booking.dto.RegisterUserDTO;
import com.example.conference_room_booking.exception.DatabaseException;
import com.example.conference_room_booking.exception.EmailIdNotFoundException;
import com.example.conference_room_booking.model.loginpage.LoginUser;
import com.example.conference_room_booking.model.loginpage.RegisterUser;
import com.example.conference_room_booking.response.LoginResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginUserDAO loginUserDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LoginResponse registerUser(RegisterUserDTO registerUserDto) {
        try {
            RegisterUser registerUser = modelMapper.map(registerUserDto, RegisterUser.class);
            return loginUserDAO.registerUser(registerUser);
        } catch(DatabaseException e) {
            return new LoginResponse(true, e.getExceptionMessage());
        }
    }

    @Override
    public LoginResponse loginUser(LoginUser loginUser) {
        try {
            return loginUserDAO.loginUser(loginUser);
        } catch(DatabaseException e) {
            return new LoginResponse(true, e.getExceptionMessage());
        }
    }

    @Override
    public ForgotUserDTO getSecurityQuestion(String emailId) {
        try {
            RegisterUser registerUser = loginUserDAO.getSecurityAnswer(emailId);
            RegisterUserDTO registerUserDTO = modelMapper.map(registerUser, RegisterUserDTO.class);
            return new ForgotUserDTO(registerUserDTO.getEmailId(), registerUserDTO.getAnswer(), registerUserDTO.getSecurityQuestion());
        } catch(EmailIdNotFoundException e) {
            return new ForgotUserDTO() {
                @Override
                public boolean getExceptionStatus() {
                    return true;
                }
                @Override
                public String getExceptionMessage() {
                    return e.getExceptionMessage();
                }
            };
        }
    }

    @Override
    public LoginResponse updatePassword(String email, String password) {
        try {
            return loginUserDAO.updatePassword(email, password);
        } catch(DatabaseException e) {
            return new LoginResponse(true, e.getExceptionMessage());
        }
    }

    @Override
    public LoginResponse pmo(String emailId, String password) {
        return loginUserDAO.pmo(emailId, password);
    }

    @Override
    public LoginResponse systemAdministrator(String email, String password) {
        return loginUserDAO.sa(email, password);
    }


}
