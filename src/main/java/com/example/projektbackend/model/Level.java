package com.example.projektbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "level")
public class Level {

    @Id
    @GeneratedValue
    private UUID level_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;
}
