package com.example.conference_room_booking.repository.loginrepository;

import com.example.conference_room_booking.model.loginpage.SystemAdministrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SystemAdminRepository extends JpaRepository<SystemAdministrator, String> {
    Optional<SystemAdministrator> findByEmailId(String emailId);
}
