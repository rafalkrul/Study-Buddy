package com.example.projektbackend.repository;


import com.example.projektbackend.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface QuizRepository extends JpaRepository<Quiz, UUID> {


    List<Quiz> findByUnitId(UUID unit_id);



}
