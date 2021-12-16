package com.example.conference_room_booking.repository.loginrepository;

import com.example.conference_room_booking.model.loginpage.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<RegisterUser, String> {

    Optional<RegisterUser> findByEmailId(String emailId);
    boolean existsByEmailId(String emailId);
}
