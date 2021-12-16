package com.example.conference_room_booking.service;

import com.example.conference_room_booking.dto.ForgotUserDTO;
import com.example.conference_room_booking.dto.RegisterUserDTO;
import com.example.conference_room_booking.model.loginpage.LoginUser;
import com.example.conference_room_booking.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    LoginResponse registerUser(RegisterUserDTO registerUser);
    LoginResponse loginUser(LoginUser loginUser);
    ForgotUserDTO getSecurityQuestion(String emailId);
    LoginResponse updatePassword(String emailId, String password);
    LoginResponse pmo(String emailId, String password);
    LoginResponse systemAdministrator(String email, String password);
}
