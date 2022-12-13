package com.example.projektbackend.service.level;

import com.example.projektbackend.DTO.level.LevelDTO;
import com.example.projektbackend.model.Level;
import com.example.projektbackend.repository.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LevelService {

    private final LevelRepository levelRepository;

    private final ModelMapper mapper;

    public UUID CreateLevel(LevelDTO level) {
        var id = UUID.randomUUID();
        var levelAdd = mapper.map(level, Level.class);

        levelAdd.setLevel_id(id);
        levelRepository.save(levelAdd);

        return id;
    }
}
