package com.example.projektbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;


import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user_created")

public class UserCreated {


    @Id
    @GeneratedValue
    private UUID user_created_id;

    @OneToOne
    private User user;

    @OneToOne
    private Flashcard flashcard;

    @OneToOne
    private Quiz quiz;
}
