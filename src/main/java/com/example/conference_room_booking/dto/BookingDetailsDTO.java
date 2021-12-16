package com.example.conference_room_booking.dto;

import com.example.conference_room_booking.model.mainpage.BookingUserDetails;
import com.example.conference_room_booking.model.mainpage.RoomDetails;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

public class BookingDetailsDTO {

    private int roomId;
    private String bookingId;
    private String bookingDate;
    private String bookingTimeFrom;
    private String bookingTimeTo;
    private int bookingDuration;
    private String description;
    private String approvalStatus;
    private String emailId;
    private String projectId;
    private String hostName;
    private String projectName;

    private RoomDetails roomDetails;

    private BookingUserDetails bookingUserDetails;


    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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

    public RoomDetails getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(RoomDetails roomDetails) {
        this.roomDetails = roomDetails;
    }

    public BookingUserDetails getBookingUserDetails() {
        return bookingUserDetails;
    }

    public void setBookingUserDetails(BookingUserDetails bookingUserDetails) {
        this.bookingUserDetails = bookingUserDetails;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "BookingDetailsDTO{" +
                "roomId=" + roomId +
                ", bookingId='" + bookingId + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", bookingTimeFrom='" + bookingTimeFrom + '\'' +
                ", bookingTimeTo='" + bookingTimeTo + '\'' +
                ", bookingDuration=" + bookingDuration +
                ", description='" + description + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", emailId='" + emailId + '\'' +
                ", projectId='" + projectId + '\'' +
                ", hostName='" + hostName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", roomDetails=" + roomDetails +
                ", bookingUserDetails=" + bookingUserDetails +
                '}';
    }
}
