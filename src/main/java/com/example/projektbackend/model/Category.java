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
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue
    private UUID category_id;

    @ManyToOne
    private Level level;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;
}
