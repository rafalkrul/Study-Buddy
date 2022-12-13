package com.example.projektbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Table;

import java.util.Date;
import java.util.Set;
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
    private UUID flashcard_id;


    @Column(nullable = false)
    private String word;

    @Column(nullable = false)
    private String translation;
}
