package com.example.projektbackend.repository;

import com.example.projektbackend.model.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FlashcardRepository extends JpaRepository<Flashcard, UUID> {


    @Query(value = "DELETE FROM flashcard_set_flashcards WHERE flashcards_id = ?", nativeQuery = true)
    void deleteFlashcardSetFlashcardsByFlashcardId(UUID flashcardId);

    @Query(value = "DELETE FROM flashcard WHERE id = ?", nativeQuery = true)
    void deleteFlashcardAndFlashcardSetFlashcardsByFlashcardId(UUID flashcardId);


}
