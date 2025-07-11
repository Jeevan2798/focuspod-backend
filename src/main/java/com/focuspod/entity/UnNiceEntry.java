package com.focuspod.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnNiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private LocalDate date;

    private String situation;  // “Boss asked for weekend work…”
    private String whatIDid;  // “I calmly said no and explained I have a personal boundary.”
    private boolean feltGuilty;
}
