package com.example.projektbackend.model;

import javax.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "singleAnswer")
public class SingleAnswer {


    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String answer;

    @Column(nullable = false)
    private boolean isRight;


}
