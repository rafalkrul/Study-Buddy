package com.example.projektbackend.repository;

import com.example.projektbackend.model.SingleAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SingleAnswerRepository extends JpaRepository<SingleAnswer, UUID> {
}
