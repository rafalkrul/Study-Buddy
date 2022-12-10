package com.example.projektbackend.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "flashcard")
public class Flashcard {

    @Id
    @GeneratedValue
    private UUID flashcard_id;


    @Column(nullable = false)
    private String word;

    @Column(nullable = false)
    private String translation;
}
