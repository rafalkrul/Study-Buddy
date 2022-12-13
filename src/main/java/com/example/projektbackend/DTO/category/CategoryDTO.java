package com.example.projektbackend.DTO.category;

import com.example.projektbackend.model.Level;
import lombok.Data;

@Data
public class CategoryDTO {


    private Level level;

    private String name;

    private String description;
}
