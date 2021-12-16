package com.example.conference_room_booking.model.mainpage;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking_details")
public class BookingDetails {

    @Id
    private String bookingId;

    private String bookingDate;
    private String bookingTimeFrom;
    private String bookingTimeTo;
    private int bookingDuration;
    private String description;
    private String approvalStatus;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomDetails roomDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "booking_user_id", referencedColumnName = "bookingUserId")
    private BookingUserDetails bookingUserDetails;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bookingDetails")
    private ApproveDetails approveDetails;

    public RoomDetails getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(RoomDetails roomDetails) {
        this.roomDetails = roomDetails;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTimeFrom() {
        return bookingTimeFrom;
    }

    public void setBookingTimeFrom(String bookingTimeFrom) {
        this.bookingTimeFrom = bookingTimeFrom;
    }

    public String getBookingTimeTo() {
        return bookingTimeTo;
    }

    public void setBookingTimeTo(String bookingTimeTo) {
        this.bookingTimeTo = bookingTimeTo;
    }

    public int getBookingDuration() {
        return bookingDuration;
    }

    public void setBookingDuration(int bookingDuration) {
        this.bookingDuration = bookingDuration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public BookingUserDetails getBookingUserDetails() {
        return bookingUserDetails;
    }

    public void setBookingUserDetails(BookingUserDetails bookingUserDetails) {
        this.bookingUserDetails = bookingUserDetails;
    }

}
