package com.example.conference_room_booking.controller;

import com.example.conference_room_booking.model.mainpage.BookingDetails;
import com.example.conference_room_booking.response.BookingResponse;
import com.example.conference_room_booking.service.BookingDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/conference_room_booking")
public class PmoController {

    @Autowired
    private BookingDetailsService bookingDetailsService;

    @GetMapping("/pmo")
    public String pmo(HttpServletRequest request) {
        List<BookingDetails> bookingDetailsList = bookingDetailsService.getApproveDetails();
        request.setAttribute("bookings", bookingDetailsList);
        return "pmo";
    }

    @GetMapping("/approve/{id}")
    public String approveBooking(@PathVariable(name = "id") String bookingId, HttpServletRequest request) {
        BookingResponse response = bookingDetailsService.approveBookingDetails(bookingId);
        HttpSession session = request.getSession();
        session.setAttribute("response_message", "approve");
        return "redirect:/conference_room_booking/pmo";
    }
}
