package com.example.projektbackend.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "flashcard_set")
public class FlashcardSet {

    @Id
    @GeneratedValue
    private UUID flashcardset_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private Level level;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "flashcardSet", cascade = CascadeType.ALL)
    private List<Flashcard> flashcards;

}
