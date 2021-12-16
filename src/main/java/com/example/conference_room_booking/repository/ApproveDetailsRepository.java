package com.example.conference_room_booking.repository;

import com.example.conference_room_booking.model.mainpage.ApproveDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApproveDetailsRepository extends JpaRepository<ApproveDetails, Integer> {
    Optional<ApproveDetails> findByApproveId(String approveId);
    void deleteByApproveId(String approveId);
}
