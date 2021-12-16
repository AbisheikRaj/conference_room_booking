package com.example.conference_room_booking.repository.loginrepository;

import com.example.conference_room_booking.model.loginpage.PMO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PmoRepository extends JpaRepository<PMO, String> {
    Optional<PMO> findByEmailId(String emailId);
}
