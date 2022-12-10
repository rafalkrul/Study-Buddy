package com.example.projektbackend.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue
    private UUID question_id;


//    @ManyToOne
//    @JoinColumn(name = "quiz_id")
//    private Quiz quiz;
    @Column(nullable = false)
    private String question;
    @Column(nullable = false)
    private String answer1;
    @Column(nullable = false)
    private String answer2;
    @Column(nullable = false)
    private String answer3;
    @Column(nullable = false)
    private String answer4;
    @Column(nullable = false)
    private String correctAnswer;

}
