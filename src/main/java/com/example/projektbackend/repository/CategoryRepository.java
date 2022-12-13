package com.example.projektbackend.repository;

import com.example.projektbackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
