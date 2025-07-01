package com.focuspod.controller;

import com.focuspod.entity.FocusSession;
import com.focuspod.service.FocusSessionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/focus-sessions")
public class FocusSessionController {

    private final FocusSessionService service;

    public FocusSessionController(FocusSessionService service) {
        this.service = service;
    }

    @PostMapping
    public FocusSession createSession(@RequestBody FocusSession session) {
        return service.saveSession(session);
    }

    @GetMapping("/{userId}")
    public List<FocusSession> getSessions(@PathVariable String userId) {
        return service.getSessionsForUser(userId);
    }

    @GetMapping("/{userId}/date")
    public List<FocusSession> getSessionsByDate(
            @PathVariable String userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return service.getSessionsForUserOnDate(userId, date);
    }
}
