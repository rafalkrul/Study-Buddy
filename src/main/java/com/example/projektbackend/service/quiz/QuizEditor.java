package com.example.projektbackend.service.quiz;


import com.example.projektbackend.DTO.quiz.QuizEditDTO;
import com.example.projektbackend.model.Quiz;
import com.example.projektbackend.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class QuizEditor {


    private final QuizRepository quizRepository;

    private final ModelMapper mapper;


    public void editQuizData(QuizEditDTO quizEditDTO){

        var quiz = QuizMapper(quizEditDTO);

        if(!quizEditDTO.getTitle().isBlank())
            quiz.setTitle(quizEditDTO.getTitle());

        if(!quizEditDTO.getDescription().isBlank())
            quiz.setDescription(quizEditDTO.getDescription());


        quizRepository.save(quiz);
    }

    public Quiz QuizMapper(QuizEditDTO quizEditDTO) {

        var quiz = quizRepository.findById(quizEditDTO.getQuiz_id());

        return mapper.map(quiz,Quiz.class);

    }


}
