package com.example.projektbackend.controller;

import com.example.projektbackend.DTO.category.CategoryDTO;
import com.example.projektbackend.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CategoryController {


    private final CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<UUID> addCategory(@RequestBody CategoryDTO category) {
        var category_id = categoryService.CreateCategory(category);
        return new ResponseEntity<>(category_id, HttpStatus.CREATED);
    }



}
