package com.focuspod.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoalReminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String goalText;    // e.g. "No phone after 9PM"
    private LocalTime startTime;   // e.g. 21:00
    private LocalTime endTime;   // e.g. 07:00

    @ElementCollection
    @CollectionTable(name = "goal_days", joinColumns = @JoinColumn(name = "goal_id"))
    @Column(name = "goal_day")
    private List<String> daysOfWeek;  // e.g. ["MON", "TUE", "WED"]
}
