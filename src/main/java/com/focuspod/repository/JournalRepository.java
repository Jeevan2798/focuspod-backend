package com.focuspod.repository;

import com.focuspod.entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public interface JournalRepository extends JpaRepository<JournalEntry, Long> {
    Optional<JournalEntry> findByUserIdAndDate(String userId, LocalDate date);

    List<JournalEntry> findByUserIdOrderByDateDesc(String userId);
}
