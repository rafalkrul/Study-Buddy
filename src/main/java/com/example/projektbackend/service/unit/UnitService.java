package com.example.projektbackend.service.unit;

import com.example.projektbackend.DTO.unit.UnitDTO;
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



    public UUID createUnit(UnitDTO unitDTO){
        var id = UUID.randomUUID();
        var unitAdd = mapper.map(unitDTO, Unit.class);

        unitAdd.setId(id);
        unitRepository.save(unitAdd);

        return id;
    }

    public List<Unit> findByCategoryAndLevel(String category, String level){


        var unit = unitRepository.findByCategoryAndLevel(category,level).stream()
                .map(unit1 -> mapper.map(unit1,Unit.class))
                .collect(Collectors.toList());

        return unit;

    }

}




