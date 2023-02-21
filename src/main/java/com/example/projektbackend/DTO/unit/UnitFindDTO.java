package com.example.projektbackend.DTO.unit;

import lombok.Data;

import java.util.UUID;
@Data
public class UnitFindDTO {

    private UUID id;
    private String category;

    private String level;

}
