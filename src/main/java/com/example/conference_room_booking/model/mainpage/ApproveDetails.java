package com.example.conference_room_booking.model.mainpage;

import javax.persistence.*;

@Entity
public class ApproveDetails {

    @Id
    private String approveId;

    private String approveType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookingId", referencedColumnName = "bookingId")
    private BookingDetails bookingDetails;

    public String getApproveId() {
        return approveId;
    }

    public void setApproveId(String approveId) {
        this.approveId = approveId;
    }

    public String getApproveType() {
        return approveType;
    }

    public void setApproveType(String approveType) {
        this.approveType = approveType;
    }

    public BookingDetails getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(BookingDetails bookingDetails) {
        this.bookingDetails = bookingDetails;
    }
}
