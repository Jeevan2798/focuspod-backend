package com.focuspod.repository;

import com.focuspod.entity.GoalReminder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalReminderRepository extends JpaRepository<GoalReminder, Long> {
    List<GoalReminder> findByUserId(String userId);
}
