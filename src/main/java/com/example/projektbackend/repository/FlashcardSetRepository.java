package com.example.projektbackend.repository;

import com.example.projektbackend.model.FlashcardSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FlashcardSetRepository extends JpaRepository<FlashcardSet, UUID> {
}
