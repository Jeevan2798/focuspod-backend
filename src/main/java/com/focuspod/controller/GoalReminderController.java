package com.focuspod.controller;

import com.focuspod.entity.GoalReminder;
import com.focuspod.service.GoalReminderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalReminderController {

    private final GoalReminderService service;

    public GoalReminderController(GoalReminderService service) {
        this.service = service;
    }

    @PostMapping
    public GoalReminder createGoal(@RequestBody GoalReminder goal) {
        return service.save(goal);
    }

    @GetMapping("/{userId}")
    public List<GoalReminder> getGoals(@PathVariable String userId) {
        return service.getGoalsByUser(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteGoal(@PathVariable Long id) {
        service.deleteGoal(id);
    }
}
