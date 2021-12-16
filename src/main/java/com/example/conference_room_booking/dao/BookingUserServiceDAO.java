package com.example.conference_room_booking.dao;

import com.example.conference_room_booking.exception.DatabaseException;
import com.example.conference_room_booking.model.mainpage.BookingUserDetails;
import com.example.conference_room_booking.repository.BookingUserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookingUserServiceDAO {

    @Autowired
    private BookingUserDetailsRepository bookingUserDetailsRepository;

    public BookingUserDetails getBookingUserService(String emailId) throws DatabaseException {
        try {
            Optional<BookingUserDetails> bookingUserDetails = bookingUserDetailsRepository.findByEmailId(emailId);
            return bookingUserDetails.orElseGet(BookingUserDetails::new);
        } catch (Exception e) {
            throw new DatabaseException("Database server is disconnected.");
        }
    }
}
