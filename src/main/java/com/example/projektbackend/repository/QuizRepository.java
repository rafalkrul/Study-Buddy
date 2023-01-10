package com.example.projektbackend.repository;

import com.example.projektbackend.DTO.quiz.QuizDTO;
import com.example.projektbackend.DTO.quiz.QuizFindDTO;
import com.example.projektbackend.model.Category;
import com.example.projektbackend.model.Level;
import com.example.projektbackend.model.Quiz;
import com.example.projektbackend.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, UUID> {


    Quiz findByCategoryIdAndLevelIdAndUnitId(UUID category_id, UUID level_id, UUID unit_id);

//    Quiz findByCategory_Category_idAndLevel_Level_idAndUnit_Unit_id(UUID category_id, UUID level_id, UUID unit_id);
//
//
//
//    @Query("SELECT q FROM quiz q WHERE q.category = :category AND q.level = :level AND q.unit = :unit")
//    Quiz findByCategoryAndLevelAndUnit(@Param("category") Category category, @Param("level") Level level, @Param("unit") Unit unit);


}
