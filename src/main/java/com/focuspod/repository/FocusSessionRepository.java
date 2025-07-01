package com.focuspod.repository;

import com.focuspod.entity.FocusSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FocusSessionRepository extends JpaRepository<FocusSession, Long> {

    // Optional: Add custom method to fetch sessions by user and date
    List<FocusSession> findByUserIdAndDate(String userId, LocalDate date);

    List<FocusSession> findByUserId(String userId);
}
