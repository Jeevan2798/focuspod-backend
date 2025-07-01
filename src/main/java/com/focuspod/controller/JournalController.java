package com.focuspod.controller;

import com.focuspod.entity.JournalEntry;
import com.focuspod.service.JournalService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/journals")
public class JournalController {

    private final JournalService service;

    public JournalController(JournalService service) {
        this.service = service;
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry entry) {
        return service.saveEntry(entry);
    }

    @GetMapping("/{userId}")
    public Optional<JournalEntry> getEntry(
            @PathVariable String userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return service.getEntryForUserOnDate(userId, date);
    }

    @GetMapping("/{userId}/all")
    public List<JournalEntry> getAllEntries(@PathVariable String userId) {
        return service.getAllEntriesForUser(userId);
    }

    @GetMapping("/testApi")
    public String testApi() {
        return "Welcome";
    }
}
