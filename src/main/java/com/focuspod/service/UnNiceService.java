package com.focuspod.service;

import com.focuspod.entity.UnNiceEntry;
import com.focuspod.repository.UnNiceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UnNiceService {

    private final UnNiceRepository repository;

    public UnNiceService(UnNiceRepository repository) {
        this.repository = repository;
    }

    public UnNiceEntry saveEntry(UnNiceEntry entry) {
        if (entry.getDate() == null) {
            entry.setDate(LocalDate.now());
        }
        return repository.save(entry);
    }

    public List<UnNiceEntry> getEntriesForUser(String userId) {
        return repository.findByUserId(userId);
    }

    public List<UnNiceEntry> getEntriesForUserByDate(String userId, LocalDate date) {
        return repository.findByUserIdAndDate(userId, date);
    }
}
