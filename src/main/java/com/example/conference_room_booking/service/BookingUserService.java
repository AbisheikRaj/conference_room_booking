package com.example.conference_room_booking.service;

import com.example.conference_room_booking.model.mainpage.BookingUserDetails;
import org.springframework.stereotype.Service;

@Service
public interface BookingUserService {

    BookingUserDetails getBookingUserService(String emailId);
}
