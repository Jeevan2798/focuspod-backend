package com.focuspod.service;

import com.focuspod.entity.FocusSession;
import com.focuspod.repository.FocusSessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FocusSessionService {

    private final FocusSessionRepository repository;

    public FocusSessionService(FocusSessionRepository repository) {
        this.repository = repository;
    }

    public FocusSession saveSession(FocusSession session) {
        if (session.getDate() == null) {
            session.setDate(LocalDate.now());
        }
        return repository.save(session);
    }

    public List<FocusSession> getSessionsForUser(String userId) {
        return repository.findByUserId(userId);
    }

    public List<FocusSession> getSessionsForUserOnDate(String userId, LocalDate date) {
        return repository.findByUserIdAndDate(userId, date);
    }
}
