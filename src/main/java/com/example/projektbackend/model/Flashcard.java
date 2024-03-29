package com.example.projektbackend.model;

import javax.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "flashcard")
public class Flashcard {

    @Id
    @GeneratedValue
    private UUID id;


    @Column(nullable = false)
    private String word;

    @Column(nullable = false)
    private String translation;
}
