package com.example.projektbackend.model;

import javax.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    private Unit unit;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;
}
