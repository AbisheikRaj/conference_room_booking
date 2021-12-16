package com.example.conference_room_booking.controller;

import com.example.conference_room_booking.dto.BookingDetailsDTO;
import com.example.conference_room_booking.model.mainpage.BookingDetails;
import com.example.conference_room_booking.model.mainpage.BookingUserDetails;
import com.example.conference_room_booking.model.mainpage.RoomDetails;
import com.example.conference_room_booking.repository.BookingDetailsRepository;
import com.example.conference_room_booking.response.BookingResponse;
import com.example.conference_room_booking.service.BookingDetailsService;
import com.example.conference_room_booking.service.BookingUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/conference_room_booking")
public class MainController {

    @Autowired
    private BookingDetailsRepository bookingDetailsRepository;

    @Autowired
    private BookingUserService bookingUserService;

    @Autowired
    private BookingDetailsService bookingDetailsService;

    @GetMapping("/ananya")
    public String ananya() {
        return "/mainpage/ananya";
    }

    @GetMapping("/apoorva")
    public String apoorva() {
        return "/mainpage/apoorva";
    }

    @GetMapping("/transfer")
    public String transfer() {
        return "/mainpage/transfer";
    }

    @GetMapping("/cancel")
    public String cancel() {
        return "/mainpage/cancel";
    }

//    @GetMapping("/booking_page")
//    public String bookingPage() {
//        return "/mainpage/bookingpage";
//    }

    @GetMapping("/booking_form")
    public String bookingForm() {
        return "/mainpage/bookingform";
    }

    @PostMapping("/booking_data")
    public String bookingDetails(BookingDetailsDTO bookingDetails, HttpServletRequest request) {
        System.out.println(bookingDetails);
        BookingResponse response = bookingDetailsService.storeBookingDetails(bookingDetails);
        HttpSession session = request.getSession();
        session.setAttribute("response_message", response.getMessage());
        return "redirect:/conference_room_booking/booking_form";
    }

    @GetMapping("/booking_page")
    public String bookingPageWithId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int roomId = Integer.parseInt(session.getAttribute("roomId").toString());
        List<BookingDetails> bookingDetails = bookingDetailsService.getBookingDetailsByRoomId(roomId);
        session.setAttribute("bookings", bookingDetails);
        return "/mainpage/bookingpage";
    }

    @GetMapping("/booking_form/{id}")
    public String bookingFormValidate(HttpServletRequest request, @PathVariable(name = "id") String roomId) {
        HttpSession session = request.getSession();
        session.setAttribute("roomId", roomId);
        return "redirect:/conference_room_booking/booking_form";
    }

    @PostMapping("/apoorva/{id}")
    public String bookingUserDetailsForApoorva(HttpServletRequest request, @PathVariable(value = "id") int roomId) {
        HttpSession session = request.getSession();
        session.setAttribute("roomId", roomId);
        return "redirect:/conference_room_booking/apoorva";
    }

    @PostMapping("/ananya/{id}")
    public String bookingUserDetailsForAnanya(HttpServletRequest request, @PathVariable(value = "id") int roomId) {
        HttpSession session = request.getSession();
        session.setAttribute("roomId", roomId);
        return "redirect:/conference_room_booking/ananya";
    }

    @GetMapping("/cancel_booking")
    public String cancelBooking(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int roomId = Integer.parseInt(session.getAttribute("roomId").toString());
        List<BookingDetails> bookingDetails = bookingDetailsService.getBookingDetailsByRoomId(roomId);
        session.setAttribute("bookings", bookingDetails);
        return "redirect:/conference_room_booking/cancel";
    }

    @GetMapping("/cancel/{id}")
    public String cancelBookingDetails(@PathVariable(name = "id") String bookingId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        BookingResponse response = bookingDetailsService.cancelBookingDetails(bookingId);
        session.setAttribute("response_message", response.getMessage());
        return "redirect:/conference_room_booking/cancel_booking";
    }

    @GetMapping("/transfer_booking")
    public String transferBooking(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int roomId = Integer.parseInt(session.getAttribute("roomId").toString());
        List<BookingDetails> bookingDetails = bookingDetailsService.getBookingDetailsByRoomId(roomId);
        session.setAttribute("bookings", bookingDetails);
        return "redirect:/conference_room_booking/transfer";
    }
}
