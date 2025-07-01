package com.focuspod.repository;

import com.focuspod.entity.UnNiceEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UnNiceRepository extends JpaRepository<UnNiceEntry, Long> {
    List<UnNiceEntry> findByUserId(String userId);

    List<UnNiceEntry> findByUserIdAndDate(String userId, LocalDate date);
}
