package com.example.conference_room_booking.service;

import com.example.conference_room_booking.dao.BookingDetailsDAO;
import com.example.conference_room_booking.dto.BookingDetailsDTO;
import com.example.conference_room_booking.exception.DatabaseException;
import com.example.conference_room_booking.model.mainpage.ApproveDetails;
import com.example.conference_room_booking.model.mainpage.BookingDetails;
import com.example.conference_room_booking.model.mainpage.BookingUserDetails;
import com.example.conference_room_booking.model.mainpage.RoomDetails;
import com.example.conference_room_booking.repository.ApproveDetailsRepository;
import com.example.conference_room_booking.response.BookingResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {

    @Autowired
    private BookingDetailsDAO bookingDetailsDAO;

    @Autowired
    private ApproveDetailsRepository approveDetailsRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<BookingDetails> getBookingDetails() {
        try {
            return bookingDetailsDAO.getBookingDetails();
        } catch (DatabaseException e) {
            return new ArrayList<>();
        }
    }

    // get booking details by room Id
    @Override
    public List<BookingDetails> getBookingDetailsByRoomId(int roomId) {
        try {
            List<BookingDetails> bookingDetailsList = bookingDetailsDAO.getBookingDetails();
            if (bookingDetailsList.isEmpty()) return new ArrayList<>();
            return bookingDetailsList.stream()
                    .filter(bookingDetails -> bookingDetails.getRoomDetails().getRoomId() == roomId)
                    .filter(bookingDetails -> bookingDetails.getApprovalStatus().equals("booked") || bookingDetails.getApprovalStatus().equals("waiting for cancellation approval") || bookingDetails.getApprovalStatus().equals("waiting for transfer approval"))
                    .collect(Collectors.toList());
        } catch (DatabaseException e) {
            return new ArrayList<>();
        }
    }

    // cancel booking details
    @Override
    public BookingResponse cancelBookingDetails(String bookingId) {
        try {
            return bookingDetailsDAO.cancelBookingDetails(bookingId);
        } catch (DatabaseException e) {
            return new BookingResponse(e.getExceptionMessage());
        }

    }

    public String generateBookingId() {
        return "BID-" + (System.currentTimeMillis() / 1000);
    }

    public BookingResponse storeBooking(BookingDetailsDTO bookingDetails) {
        bookingDetails.setApprovalStatus("waiting for booking approval");

        BookingUserDetails bookingUserDetails = new BookingUserDetails();
        bookingUserDetails.setEmailId(bookingDetails.getEmailId());
        bookingUserDetails.setHostName(bookingDetails.getHostName());
        bookingUserDetails.setProjectId(Long.parseLong(bookingDetails.getProjectId()));
        bookingUserDetails.setProjectName(bookingDetails.getProjectName());

        bookingDetails.setBookingUserDetails(bookingUserDetails);

        RoomDetails roomDetails = new RoomDetails();
        roomDetails.setRoomId(bookingDetails.getRoomId());
        roomDetails.setRoomName(bookingDetails.getRoomId() == 1 ? "apoorva" : "ananya");

        bookingDetails.setRoomDetails(roomDetails);

        BookingDetails bookingDetails1 = modelMapper.map(bookingDetails, BookingDetails.class);
        try {
            return bookingDetailsDAO.storeBookingDetails(bookingDetails1);
        } catch (DatabaseException e) {
            return new BookingResponse(e.getExceptionMessage());
        }
    }

    public BookingResponse checkCurrentTimeAndStore(BookingDetailsDTO bookingDetails) {
        // current time
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.MINUTE, 30);
        DateFormat outFormat = new SimpleDateFormat( "HH:mm");
        String currentDate = outFormat.format(calendar.getTime());


        String bookingTime = bookingDetails.getBookingTimeFrom();
        System.out.println(bookingTime + " " + currentDate);
        if (bookingTime.compareTo(currentDate) >= 0) {
            return storeBooking(bookingDetails);
        }
        return new BookingResponse("You have to book before 30 minutes");
    }

    @Override
    public BookingResponse storeBookingDetails(BookingDetailsDTO bookingDetails) {
        Calendar c = Calendar.getInstance();
        String currentDate = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE);
        bookingDetails.setBookingId(generateBookingId());
        try {
            List<BookingDetails> acceptStoreData = bookingDetailsDAO.checkBookingsAvailable(bookingDetails.getBookingDate(), bookingDetails.getRoomId());
            if (!acceptStoreData.isEmpty()) {
                String bookingFrom = bookingDetails.getBookingTimeFrom();
                String bookingTo = bookingDetails.getBookingTimeTo();
                boolean accept = true;
                for (BookingDetails bookingDetails1 : acceptStoreData) {
                    if ((bookingDetails1.getBookingTimeFrom().compareTo(bookingFrom) == 0 || bookingDetails1.getBookingTimeTo().compareTo(bookingTo) == 0)
                        || (bookingDetails1.getBookingTimeFrom().compareTo(bookingFrom) > 0 && bookingDetails1.getBookingTimeFrom().compareTo(bookingTo) < 0)
                            || (bookingDetails1.getBookingTimeTo().compareTo(bookingFrom) > 0 && bookingDetails1.getBookingTimeTo().compareTo(bookingTo) < 0))
                    {
                                    accept = false;
                                    break;
                    }
                }

                if (accept) return checkCurrentTimeAndStore(bookingDetails);

                return new BookingResponse("Already Booked");

             } else if (bookingDetails.getBookingDate().equals(currentDate)) {
                return checkCurrentTimeAndStore(bookingDetails);
            }
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        return storeBooking(bookingDetails);
    }

    @Override
    public BookingResponse deleteBookingDetails(String approveId) {
        try {
            return bookingDetailsDAO.deleteBooking(approveId);
        } catch(DatabaseException e) {
            return new BookingResponse(e.getExceptionMessage());
        }
    }

    @Override
    public BookingResponse approveBookingDetails(String approveId) {
        try {
            return bookingDetailsDAO.approveBooking(approveId);
        } catch (DatabaseException e) {
            return new BookingResponse(e.getExceptionMessage());
        }
    }

    @Override
    public List<BookingDetails> getApproveDetails() {
        try {
            List<ApproveDetails> approveDetails = bookingDetailsDAO.getApproveDetails();
            if (!approveDetails.isEmpty()) {
                return approveDetails.stream()
                        .map(ApproveDetails::getBookingDetails)
                        .collect(Collectors.toList());
            }
        } catch(DatabaseException e) {
           return new ArrayList<>();
        }
        return new ArrayList<>();
    }
}
