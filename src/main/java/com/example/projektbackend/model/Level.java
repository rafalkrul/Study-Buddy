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
@Table(name = "level")
public class Level {

    @Id
    @GeneratedValue
    private UUID level_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;
}
