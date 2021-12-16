package com.example.conference_room_booking.repository.loginrepository;

import com.example.conference_room_booking.model.loginpage.LockedUserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LockedUserAccountRepository extends JpaRepository<LockedUserAccount, String> {
    Optional<LockedUserAccount> findByEmailId(String emailId);
}
