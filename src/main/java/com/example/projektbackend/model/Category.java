package com.example.projektbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "category")
public class Category {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Level level;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;
}
