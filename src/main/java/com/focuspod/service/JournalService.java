package com.focuspod.service;

import com.focuspod.entity.JournalEntry;
import com.focuspod.repository.JournalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class JournalService {

    private final JournalRepository repository;

    public JournalService(JournalRepository repository) {
        this.repository = repository;
    }

    public JournalEntry saveEntry(JournalEntry entry) {
        if (entry.getDate() == null) {
            entry.setDate(LocalDate.now());
        }
        return repository.save(entry);
    }

    public Optional<JournalEntry> getEntryForUserOnDate(String userId, LocalDate date) {
        return repository.findByUserIdAndDate(userId, date);
    }

    public List<JournalEntry> getAllEntriesForUser(String userId) {
        return repository.findByUserIdOrderByDateDesc(userId);
    }

}
