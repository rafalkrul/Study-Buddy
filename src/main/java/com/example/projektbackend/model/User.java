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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID user_id;

    @CreationTimestamp
    @Column(nullable = false)
    private Date createdAt;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;


    @Column(unique = true, nullable = false)
    private String email;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean isAdmin = false;

    @OneToMany(mappedBy = "user")
    private List<FlashcardSet> flashcardSets;

    @OneToMany(mappedBy = "user")
    private List<Quiz> quizzes;


}
