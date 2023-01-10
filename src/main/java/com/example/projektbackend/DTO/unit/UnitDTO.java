package com.example.projektbackend.DTO.unit;

import com.example.projektbackend.model.Category;
import com.example.projektbackend.model.Level;
import lombok.Data;

@Data
public class UnitDTO {


    private String name;


    private String description;


    private Category category;


    private Level level;



}
