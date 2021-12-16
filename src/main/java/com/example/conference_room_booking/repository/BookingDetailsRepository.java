package com.example.conference_room_booking.repository;

import com.example.conference_room_booking.model.mainpage.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Integer> {

    @Query("select b from BookingDetails b")
    Optional<List<BookingDetails>> findByAll();

    @Query("select b from BookingDetails b where b.bookingDate = ?1 and b.roomDetails.roomId = ?2")
    Optional<List<BookingDetails>> findByBookingDate(String bookingDate, int roomId);

    Optional<BookingDetails> findByBookingId(String bookingId);
}
