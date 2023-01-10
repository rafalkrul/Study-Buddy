package com.example.projektbackend.repository;

import com.example.projektbackend.DTO.unit.UnitFindDTO;
import com.example.projektbackend.model.Category;
import com.example.projektbackend.model.Level;
import com.example.projektbackend.model.Quiz;
import com.example.projektbackend.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UnitRepository extends JpaRepository<Unit, UUID> {



    List<Unit> findByCategoryIdAndLevelId(UUID category_id, UUID level_id);



}
