package com.example.projektbackend;

import com.example.projektbackend.model.Question;
import com.example.projektbackend.model.QuestionPostDTO;
import com.example.projektbackend.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/question")
public class QuestionController {
    private final ModelMapper mapper;
    private final QuestionRepository questionRepository;

    @PostMapping
    public UUID addQuestion(@RequestBody QuestionPostDTO question) {
        var id = UUID.randomUUID();
        var questionAdd = mapper.map(question, Question.class);

        questionAdd.setQuestion_id(id);
        questionRepository.save(questionAdd);

        return id;
    }
}
