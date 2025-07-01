package com.focuspod.service;

import com.focuspod.entity.GoalReminder;
import com.focuspod.repository.GoalReminderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalReminderService {

    private final GoalReminderRepository repository;

    public GoalReminderService(GoalReminderRepository repository) {
        this.repository = repository;
    }

    public GoalReminder save(GoalReminder goal) {
        return repository.save(goal);
    }

    public List<GoalReminder> getGoalsByUser(String userId) {
        return repository.findByUserId(userId);
    }

    public void deleteGoal(Long id) {
        repository.deleteById(id);
    }
}
