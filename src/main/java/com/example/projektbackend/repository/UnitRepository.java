package com.example.projektbackend.repository;

import com.example.projektbackend.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UnitRepository extends JpaRepository<Unit, UUID> {


    List<Unit> findByCategoryAndLevel(String category, String level);


}
