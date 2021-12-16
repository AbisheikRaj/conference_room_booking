package com.example.conference_room_booking.repository;

import com.example.conference_room_booking.model.mainpage.BookingUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingUserDetailsRepository extends JpaRepository<BookingUserDetails, String> {

    Optional<BookingUserDetails> findByEmailId(String emailId);
}
