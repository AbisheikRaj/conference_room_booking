package com.example.conference_room_booking.dao;

import com.example.conference_room_booking.exception.DatabaseException;
import com.example.conference_room_booking.model.mainpage.ApproveDetails;
import com.example.conference_room_booking.model.mainpage.BookingDetails;
import com.example.conference_room_booking.repository.ApproveDetailsRepository;
import com.example.conference_room_booking.repository.BookingDetailsRepository;
import com.example.conference_room_booking.response.BookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class BookingDetailsDAO {

    @Autowired
    private BookingDetailsRepository bookingDetailsRepository;

    @Autowired
    private ApproveDetailsRepository approveDetailsRepository;

    public List<BookingDetails> getBookingDetails() throws DatabaseException {
        try {
            Optional<List<BookingDetails>> bookingDetails = bookingDetailsRepository.findByAll();
            return bookingDetails.orElseGet(ArrayList::new);
        } catch (Exception e) {
            throw new DatabaseException("Database server is disconnected.");
        }
    }

    // Store the booking details
    public BookingResponse storeBookingDetails(BookingDetails bookingDetails) throws DatabaseException {
        try {
            ApproveDetails approveDetails = new ApproveDetails();
            approveDetails.setApproveId(bookingDetails.getBookingId());
            approveDetails.setApproveType("Booking");
            approveDetails.setBookingDetails(bookingDetails);
            approveDetailsRepository.save(approveDetails);
        } catch(Exception e) {
            e.printStackTrace();
            throw new DatabaseException("Database Server is disconnected");
        }
        return new BookingResponse("approval");
    }

    public List<BookingDetails> checkBookingsAvailable(String bookingDate, int roomId) throws DatabaseException {
        try {
            Optional<List<BookingDetails>> bookingDetails = bookingDetailsRepository.findByBookingDate(bookingDate, roomId);
            if (bookingDetails.isPresent()) {
                return bookingDetails.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException("Database Server is disconnected");
        }
        return new ArrayList<>();
    }

    // Cancel the booking details
    public BookingResponse cancelBookingDetails(String bookingId) throws DatabaseException {
        Optional<BookingDetails> bookingDetails = bookingDetailsRepository.findByBookingId(bookingId);
        try {
            if (bookingDetails.isPresent()) {
                BookingDetails bookingDetails1 = bookingDetails.get();
//                String convertTime = bookingDetails1.getBookingTimeFrom().replace(":", ".");
//                double bookingFrom = Double.parseDouble(convertTime);
//                LocalDateTime localDateTime = LocalDateTime.now();
//                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
//                double now = Double.parseDouble(dtf.format(localDateTime).replace(":", "."));
                  Calendar c = Calendar.getInstance();
                  c.setTimeInMillis(System.currentTimeMillis());
                  c.add(Calendar.HOUR, 1);
                  String now = new SimpleDateFormat("HH:mm").format(c.getTime());
                  String bookingFrom = bookingDetails1.getBookingTimeFrom();
//                String currentDate = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE);
                System.out.println(now + " " + bookingFrom);
                if (now.compareTo(bookingFrom) <= 0) {/*&& currentDate.compareTo(bookingDetails1.getBookingDate()) <= 0*/
                    bookingDetails.get().setApprovalStatus("cancelled");
                    bookingDetailsRepository.save(bookingDetails.get());
                    return new BookingResponse("Your booking is cancelled");
                }
//                Optional<ApproveDetails> approveDetails = approveDetailsRepository.findByApproveId(bookingId);
//                if (approveDetails.isPresent()) {
//                    approveDetails.get().setApproveType("cancellation");
//                    bookingDetails.get().setApprovalStatus("waiting for cancellation approval");
//                    approveDetails.get().setBookingDetails(bookingDetails.get());
//                    approveDetailsRepository.save(approveDetails.get());
//                }

            }
        } catch(Exception e) {
            e.printStackTrace();
            throw new DatabaseException("Database Server is disconnected.");
        }
        return new BookingResponse("Cancellation is not allowed");
    }

    public BookingResponse deleteBooking(String approveId) throws DatabaseException {
        try {
            approveDetailsRepository.deleteByApproveId(approveId);
        } catch (Exception e) {
            throw new DatabaseException("Database server is disconnected.");
        }
        return new BookingResponse("Booking details are successfully deleted.");
    }

    public BookingResponse approveBooking(String bookingId) throws DatabaseException {
        try {
            Optional<ApproveDetails> approveDetails = approveDetailsRepository.findByApproveId(bookingId);
            if (approveDetails.isPresent()) {
                ApproveDetails details = approveDetails.get();
                if (details.getBookingDetails().getApprovalStatus().equals("waiting for booking approval")) {
                    details.setApproveType("Approved");
                    details.getBookingDetails().setApprovalStatus("booked");
                    approveDetailsRepository.save(details);
                }
//                } else {
//                    details.setApproveType("Approved");
//                    details.getBookingDetails().setApprovalStatus("cancelled");
//                    approveDetailsRepository.save(details);
//                }
            }
        } catch (Exception e) {
            throw new DatabaseException("Database server is disconnected.");
        }
        return new BookingResponse("Booking details approved.");
    }

    public List<ApproveDetails> getApproveDetails() throws DatabaseException {
        try {
            return approveDetailsRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException("Database Server is disconnected");
        }
    }
}
