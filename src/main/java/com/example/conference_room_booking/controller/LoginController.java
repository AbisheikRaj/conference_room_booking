package com.example.conference_room_booking.controller;

import com.example.conference_room_booking.dto.ForgotUserDTO;
import com.example.conference_room_booking.dto.RegisterUserDTO;
import com.example.conference_room_booking.model.loginpage.ForgotUser;
import com.example.conference_room_booking.model.loginpage.LoginUser;
import com.example.conference_room_booking.response.LoginResponse;
import com.example.conference_room_booking.service.BookingUserService;
import com.example.conference_room_booking.service.LoginService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/conference_room_booking")
public class LoginController {

	private static Logger log = Logger.getLogger(LoginController.class.getName());
    private static final String RESPONSE_MESSAGE = "response_message";
    private static final String RESPONSE_STATUS = "response_status";
    private static final String REDIRECT_TO_LOGIN = "redirect:/conference_room_booking/login";
    private static final String REDIRECT_TO_FORGOT_PASSWORD = "redirect:/conference_room_booking/forgot_password";
    private static final String EMAIL_ID = "email_id";
    private static final String SECURITY_FORM = "security_form";

    @Autowired
    private LoginService loginService;

    @Autowired
    private BookingUserService bookingUserService;

    // Requesting JSP Page

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
    	log.info("Entering Login Page");
        return "login";
    }

    @GetMapping("/register")
    public String register() {
    	log.info("Entering Register Page");
        return "register";
    }

    @GetMapping("/forgot_password")
    public String forgotPassword() {
    	log.info("Entering forgotpassword Page");
        return "forgotPassword";
    }

    @GetMapping("/home")
    public String home(HttpServletRequest request) {
        return "home";
    }

    @GetMapping("/sa")
    public String systemAdministrator() {
    	log.info("Entering System Administrator Page");
        return "systemAdministrator";
    }

    // Server side Validation

    @PostMapping(value = "/validate_register")
    public String validateRegisterDetails(RegisterUserDTO registerUser, HttpServletRequest request) {
        HttpSession session = request.getSession();
        LoginResponse responseMessage = loginService.registerUser(registerUser);
        if (responseMessage.getExceptionStatus()) {
            session.setAttribute(RESPONSE_MESSAGE, responseMessage.getResponseMessage()); // failure
            session.setAttribute(RESPONSE_STATUS, responseMessage.getExceptionStatus());
            return "redirect:/conference_room_booking/register";
        }
        session.setAttribute(RESPONSE_MESSAGE, responseMessage.getResponseMessage());
        session.setAttribute(RESPONSE_STATUS, responseMessage.getExceptionStatus());
        return REDIRECT_TO_LOGIN;
    }

    @PostMapping(value = "/validate_login")
    public String validateLoginDetails(LoginUser loginUser, HttpServletRequest request) {
        HttpSession session = request.getSession();
        LoginResponse response = loginService.loginUser(loginUser);
        if (response.getExceptionStatus()) {
            if (!loginService.pmo(loginUser.getEmailId(), loginUser.getPassword()).getExceptionStatus()) {
                session.setAttribute("accept_pmo", loginUser.getEmailId());
                log.info("PMO Login is successful");
                return "redirect:/conference_room_booking/pmo";
            } else if (!loginService.systemAdministrator(loginUser.getEmailId(), loginUser.getPassword()).getExceptionStatus()) {
                session.setAttribute("accept_sa", loginUser.getEmailId());
                log.info("System administrator Login is successful");
                return "redirect:/conference_room_booking/sa";
            }
            session.setAttribute(RESPONSE_MESSAGE, response.getResponseMessage()); // failure
            session.setAttribute(RESPONSE_STATUS, response.getExceptionStatus());
            return REDIRECT_TO_LOGIN;
        }
        session.setAttribute("accept_user", loginUser.getEmailId());
        log.info("User Login is successful");
        return "redirect:/conference_room_booking/home";
    }


    @PostMapping("/reset_password")
    public String validateResetPasswordDetails(ForgotUser forgotUser, HttpServletRequest request) {
        HttpSession session = request.getSession();
        ForgotUserDTO forgotUserDTO = loginService.getSecurityQuestion(session.getAttribute(EMAIL_ID).toString());
        if (!forgotUserDTO.getExceptionStatus() && forgotUser.getSecurityAnswer().equals(forgotUserDTO.getAnswer())) {
                log.info("resetpassword is successful");
                return "resetPassword";
        }
        session.setAttribute(RESPONSE_MESSAGE, "Your security answer is incorrect.");
        session.setAttribute(RESPONSE_STATUS, true);
        session.setAttribute(SECURITY_FORM, null);
        return REDIRECT_TO_FORGOT_PASSWORD;
    }

    @PostMapping("/forgot_password")
    public String validateForgotDetails(ForgotUser forgotUser, HttpServletRequest request) {
        HttpSession session = request.getSession();
        ForgotUserDTO forgotUserDTO = loginService.getSecurityQuestion(forgotUser.getEmailId());
        if (forgotUserDTO.getExceptionStatus()) {
            session.setAttribute(SECURITY_FORM, null);
            session.setAttribute(RESPONSE_MESSAGE, forgotUserDTO.getExceptionMessage());
            session.setAttribute(EMAIL_ID, forgotUser.getEmailId());
            session.setAttribute(RESPONSE_STATUS, true);
        } else {
            String question = forgotUserDTO.getSecurityQuestion().replace(" ", "&nbsp;");
            session.setAttribute(SECURITY_FORM, true);
            session.setAttribute(RESPONSE_MESSAGE, null);
            session.setAttribute(EMAIL_ID, forgotUser.getEmailId());
            session.setAttribute("security_question", question);
        }
        return REDIRECT_TO_FORGOT_PASSWORD;
    }

    // Update Password

    @PostMapping(value = "/update_password")
    public String updatePassword(LoginUser password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        LoginResponse response = loginService.updatePassword(session.getAttribute(EMAIL_ID).toString(), password.getPassword());
        session.setAttribute(RESPONSE_MESSAGE, response.getResponseMessage());
        session.setAttribute(RESPONSE_STATUS, response.getExceptionStatus());
        return REDIRECT_TO_LOGIN;
    }

    //logout

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        log.info("Logout is successful");
        HttpSession session = request.getSession();
        session.setAttribute("response_message", null);
        return REDIRECT_TO_LOGIN;
    }
}
