package com.example.projektbackend.controller;

import com.example.projektbackend.DTO.unit.UnitDTO;
import com.example.projektbackend.DTO.unit.UnitFindDTO;
import com.example.projektbackend.model.Category;
import com.example.projektbackend.model.Level;
import com.example.projektbackend.model.Unit;
import com.example.projektbackend.repository.UnitRepository;
import com.example.projektbackend.service.unit.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UnitController {

    private final UnitService unitService;



    @GetMapping("/units")
    public ResponseEntity<List<Unit>> findUnitByCategoryAndLevel(@RequestBody UnitFindDTO unitFindDTO){
        var unit = unitService.findUnitByCategoryAndLevel(unitFindDTO.getCategory_id(),unitFindDTO.getLevel_id());
        return new ResponseEntity<>(unit, HttpStatus.OK);
    }

}
