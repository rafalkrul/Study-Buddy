package com.example.projektbackend.service.quiz;

import com.example.projektbackend.DTO.question.QuestionDTO;
import com.example.projektbackend.DTO.quiz.QuizEditDTO;
import com.example.projektbackend.DTO.quiz.QuizGetDTO;
import com.example.projektbackend.DTO.quiz.QuizPostDTO;
import com.example.projektbackend.DTO.singleanswer.SingleAnswerDTO;
import com.example.projektbackend.model.*;
import com.example.projektbackend.repository.LevelRepository;
import com.example.projektbackend.repository.QuestionRepository;
import com.example.projektbackend.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizService {


    private final QuizRepository quizRepository;


    private final QuizEditor quizEditor;


    private final ModelMapper mapper;


    public UUID CreateQuiz(QuizPostDTO quizPostDTO) {
        UUID id = UUID.randomUUID();

        Quiz quiz = mapper.map(quizPostDTO.getQuizDTO(), Quiz.class);

//        var questionsAdd = quizPostDTO.getQuestionsDTO()
//                        .stream()
//                .map(questionDTO -> mapper.map(questionDTO, Question.class))
//                .collect(Collectors.toList());


        var questionsAdd = quizPostDTO.getQuestionsDTO()
                .stream()
                .map(questionDTO -> {
                    Question question = mapper.map(questionDTO, Question.class);
                    List<SingleAnswer> answers = questionDTO.getAnswerListDTO().stream()
                            .map(answerDTO -> mapper.map(answerDTO, SingleAnswer.class))
                            .collect(Collectors.toList());
                    question.setAnswers(answers);
                    return question;
                })
                .collect(Collectors.toList());

        quiz.setQuestions(questionsAdd);

      //  questionRepository.saveAll(questionsAdd);

        quizRepository.save(quiz);
        return id;
    }

    public void EditQuizData (QuizEditDTO quizEditDTO){
        quizEditor.editQuizData(quizEditDTO);
    }

    public void AddQuestionToQuiz(QuizEditDTO quizEditDTO){

        var quiz = QuizMapper(quizEditDTO);

        var questions = quizEditDTO.getQuestionsDTO().
                stream()
                .map(questionDTO -> mapper.map(questionDTO, Question.class))
                .collect(Collectors.toList());

        quiz.getQuestions().addAll(questions);

        quizRepository.save(quiz);
    }

    public Quiz QuizMapper(QuizEditDTO quizEditDTO){

        var quiz = quizRepository.findById(quizEditDTO.getQuiz_id());

        return mapper.map(quiz, Quiz.class);
    }

//    public QuizGetDTO GetQuizById(UUID quiz_id){
//
//        var quiz = quizRepository.findById(quiz_id);
//
//        return mapper.map(quiz, QuizGetDTO.class);
//    }

    public QuizGetDTO GetQuizById(UUID quiz_id){
        var quiz = quizRepository.findById(quiz_id).orElseThrow(() -> new RuntimeException("dfsdfsdfs"));
        QuizGetDTO quizGetDTO = mapper.map(quiz, QuizGetDTO.class);
        quizGetDTO.setQuestions(quiz.getQuestions());
        return quizGetDTO;
    }


    public Quiz findByCategoryIdAndLevelIdAndUnitId(UUID category_id, UUID level_id, UUID unit_id) {

        return quizRepository.findByCategoryIdAndLevelIdAndUnitId(category_id,level_id,unit_id);
    }

    public QuizGetDTO findAllByCategoryId(UUID category_id){
        var quiz =  quizRepository.findAllByCategoryId(category_id);
        QuizGetDTO quizGetDTO = mapper.map(quiz, QuizGetDTO.class);
        quizGetDTO.setQuestions(quiz.getQuestions());
        return quizGetDTO;
    }



}
