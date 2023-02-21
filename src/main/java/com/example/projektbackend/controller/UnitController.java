package com.example.projektbackend.controller;

import com.example.projektbackend.DTO.unit.UnitDTO;
import com.example.projektbackend.DTO.unit.UnitFindDTO;
import com.example.projektbackend.model.Unit;
import com.example.projektbackend.service.unit.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UnitController {

    private final UnitService unitService;


    @PostMapping("/unit")
    public ResponseEntity<UUID> addUnit(@RequestBody UnitDTO unitDTO) {
        var unit = unitService.createUnit(unitDTO);
        return new ResponseEntity<>(unit, HttpStatus.CREATED);
    }



    @GetMapping("/units")
    public ResponseEntity<List<Unit>> findUnitByCategoryAndLevel(@RequestBody UnitFindDTO unitFindDTO){
        var unit = unitService.findByCategoryAndLevel(unitFindDTO.getCategory(),unitFindDTO.getLevel());
        return new ResponseEntity<>(unit, HttpStatus.OK);
    }

}
