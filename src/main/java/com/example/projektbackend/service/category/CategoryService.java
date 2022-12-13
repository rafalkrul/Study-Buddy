package com.example.projektbackend.service.category;

import com.example.projektbackend.DTO.category.CategoryDTO;
import com.example.projektbackend.DTO.level.LevelDTO;
import com.example.projektbackend.model.Category;
import com.example.projektbackend.model.Level;
import com.example.projektbackend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {


    private final CategoryRepository categoryRepository;

    private final ModelMapper mapper;

    public UUID CreateCategory(CategoryDTO category) {
        var id = UUID.randomUUID();
        var categoryAdd = mapper.map(category, Category.class);

        categoryAdd.setCategory_id(id);
        categoryRepository.save(categoryAdd);

        return id;
    }
}
