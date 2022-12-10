package com.example.projektbackend.model;

import lombok.*;


import javax.persistence.*;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_created")
public class UserCreated {


    @OneToOne
    private User user;

    @OneToOne
    private Flashcard flashcard;

    @OneToOne
    private Quiz quiz;
}
