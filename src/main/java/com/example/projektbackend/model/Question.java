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
@Entity(name = "question")
public class Question {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String question;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SingleAnswer> answers;

}
