package com.example.conference_room_booking.model.mainpage;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
@Table(name = "booking_user_details")
public class BookingUserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingUserId;

    private String emailId;
    private String hostName;
    private long projectId;
    private String projectName;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bookingUserDetails")
    @JsonBackReference
    private BookingDetails bookingDetails;

    public BookingUserDetails() {
    }

    public BookingUserDetails(String emailId, String hostName, long projectId, String projectName, BookingDetails bookingDetails) {
        this.emailId = emailId;
        this.hostName = hostName;
        this.projectId = projectId;
        this.projectName = projectName;
        this.bookingDetails = bookingDetails;
    }

    public int getBookingUserId() {
        return bookingUserId;
    }

    public void setBookingUserId(int bookingUserId) {
        this.bookingUserId = bookingUserId;
    }

    public BookingDetails getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(BookingDetails bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

}
