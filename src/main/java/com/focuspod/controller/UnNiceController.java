package com.focuspod.controller;

import com.focuspod.entity.UnNiceEntry;
import com.focuspod.service.UnNiceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/unnice")
public class UnNiceController {

    private final UnNiceService service;

    public UnNiceController(UnNiceService service) {
        this.service = service;
    }

    @PostMapping
    public UnNiceEntry createEntry(@RequestBody UnNiceEntry entry) {
        return service.saveEntry(entry);
    }

    @GetMapping("/{userId}")
    public List<UnNiceEntry> getEntries(@PathVariable String userId) {
        return service.getEntriesForUser(userId);
    }

    @GetMapping("/{userId}/date")
    public List<UnNiceEntry> getEntriesByDate(
            @PathVariable String userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return service.getEntriesForUserByDate(userId, date);
    }
}
