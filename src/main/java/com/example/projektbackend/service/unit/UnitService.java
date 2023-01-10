package com.example.projektbackend.service.unit;

import com.example.projektbackend.DTO.unit.UnitDTO;
import com.example.projektbackend.DTO.unit.UnitFindDTO;
import com.example.projektbackend.model.Category;
import com.example.projektbackend.model.Level;
import com.example.projektbackend.model.Unit;
import com.example.projektbackend.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UnitService {


    private final UnitRepository unitRepository;

    private final ModelMapper mapper;



    public List<Unit> findUnitByCategoryAndLevel(UUID category_id, UUID level_id){


        var unit = unitRepository.findByCategoryIdAndLevelId(category_id, level_id).stream()
                .map(unit1 -> mapper.map(unit1,Unit.class))
                .collect(Collectors.toList());

        return unit;

    }

}




