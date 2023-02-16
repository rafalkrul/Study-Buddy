package com.example.projektbackend.model;


import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @CreationTimestamp
    @Column(nullable = false)
    private Date createdAt;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;


    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String role;

    @OneToMany(mappedBy = "user")
    private List<FlashcardSet> flashcardSets;

}
