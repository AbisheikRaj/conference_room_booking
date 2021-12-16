package com.example.conference_room_booking.service;

import com.example.conference_room_booking.dto.BookingDetailsDTO;
import com.example.conference_room_booking.exception.DatabaseException;
import com.example.conference_room_booking.model.mainpage.ApproveDetails;
import com.example.conference_room_booking.model.mainpage.BookingDetails;
import com.example.conference_room_booking.response.BookingResponse;

import java.text.ParseException;
import java.util.List;


public interface BookingDetailsService {

    List<BookingDetails> getBookingDetails();
    List<BookingDetails> getBookingDetailsByRoomId(int roomId);
    BookingResponse cancelBookingDetails(String bookingId);
    BookingResponse storeBookingDetails(BookingDetailsDTO bookingDetails);
    BookingResponse deleteBookingDetails(String bookingId);
    BookingResponse approveBookingDetails(String bookingId);
    List<BookingDetails> getApproveDetails();
}
