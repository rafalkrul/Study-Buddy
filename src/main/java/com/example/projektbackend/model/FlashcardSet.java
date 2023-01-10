package com.example.projektbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "flashcard_set")
public class FlashcardSet {

    @Id
    @GeneratedValue
    private UUID flashcardset_id;

    @ManyToOne
    private Level level;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Flashcard> flashcards;

}
