package com.focuspod.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_user")
public class User {

    @Id
    private String id; // Could be Firebase UID or internal ID like "user1"

    private String name;
    private String email;

    private String timezone; // optional for reminders
}
