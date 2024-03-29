package com.example.projektbackend.service.question;

import com.example.projektbackend.DTO.question.QuestionDTO;
import com.example.projektbackend.model.Question;
import com.example.projektbackend.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    private final ModelMapper mapper;

    public UUID CreateQuestion(QuestionDTO questionDTO) {
        var id = UUID.randomUUID();
        var questionAdd = mapper.map(questionDTO, Question.class);

        questionAdd.setId(id);
        questionRepository.save(questionAdd);

        return id;
    }

    public void deleteQuestionById(UUID question_id){
        questionRepository.deleteById(question_id);
    }

}
