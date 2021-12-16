package com.example.conference_room_booking.service;

import com.example.conference_room_booking.dao.BookingUserServiceDAO;
import com.example.conference_room_booking.exception.DatabaseException;
import com.example.conference_room_booking.model.mainpage.BookingUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingUserServiceImpl implements BookingUserService{

    @Autowired
    private BookingUserServiceDAO bookingUserServiceDAO;

    @Override
    public BookingUserDetails getBookingUserService(String emailId) {
        try {
            return bookingUserServiceDAO.getBookingUserService(emailId);
        } catch (DatabaseException e) {
            return new BookingUserDetails();
        }
    }
}
