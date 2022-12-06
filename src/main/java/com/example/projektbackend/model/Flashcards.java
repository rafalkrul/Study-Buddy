package com.example.projektbackend.model;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

public class Flashcards {

    @Id
    @GeneratedValue
    private UUID flashcards_id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToMany(mappedBy = "flashcards")
    private Set<Flashcards> flashcards;

}
