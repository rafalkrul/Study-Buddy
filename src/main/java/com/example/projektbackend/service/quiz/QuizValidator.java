package com.example.projektbackend.service.quiz;

import com.example.projektbackend.DTO.quiz.QuizEditDTO;
import com.example.projektbackend.DTO.quiz.QuizPostDTO;
import com.example.projektbackend.execptions.InvalidEditData;
import com.example.projektbackend.execptions.InvalidRegisterData;
import com.example.projektbackend.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuizValidator {


    private final QuizRepository quizRepository;


    public void ValidateQuiz(QuizPostDTO quizPostDTO){

        if(quizPostDTO.getQuizDTO().getTitle().length() < 3)
            throw new InvalidRegisterData("Tytuł Quizu powinien zawierać conajmniej 3 liter");

        if(quizPostDTO.getQuizDTO().getDescription().isBlank())
            throw new InvalidRegisterData("Quiz powinien zawierać opis");

        if(quizPostDTO.getQuizDTO().getCategory().getId().equals(0))
            throw new InvalidRegisterData("Quiz powinien zawierać kategorię");

        if(quizPostDTO.getQuizDTO().getLevel().getId().equals(0))
            throw new InvalidRegisterData("Quiz powinien zawierać poziom");

        if(quizPostDTO.getQuizDTO().getUnit().getId().equals(0))
            throw new InvalidRegisterData("Quiz powinien zawierać Unit");

    }

    public void ValidateEditQuiz(QuizEditDTO quizEditDTO){

        var quiz = quizRepository.findById(quizEditDTO.getQuiz_id());

        if(quizEditDTO.getTitle().equals(quiz.get().getTitle()))
            throw new InvalidEditData("Tytuł Quizu jest identyczny");

        if(quizEditDTO.getDescription().equals(quiz.get().getDescription()))
            throw new InvalidRegisterData("Opis quizu jest identyczny");


    }

}
