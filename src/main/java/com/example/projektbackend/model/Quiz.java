package com.example.projektbackend.model;

import jakarta.persistence.*;
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
    private UUID quiz_id;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Level level;

    @ManyToOne
    private User user;

    @ManyToOne
    private Unit unit;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "question_id", cascade = CascadeType.ALL)
    private List<Question> questions;
}
