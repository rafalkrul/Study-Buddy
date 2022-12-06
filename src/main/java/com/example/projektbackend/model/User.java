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

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean isAdmin = false;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "track",
            joinColumns = { @JoinColumn(name = "recording_id") },
            inverseJoinColumns = { @JoinColumn(name = "release_id") }


}
