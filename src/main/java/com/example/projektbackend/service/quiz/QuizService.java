package com.example.projektbackend.service.quiz;

import com.example.projektbackend.DTO.quiz.QuizPostDTO;
import com.example.projektbackend.model.Question;
import com.example.projektbackend.model.Quiz;
import com.example.projektbackend.repository.QuestionRepository;
import com.example.projektbackend.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizService {


    private final QuizRepository quizRepository;

    private final QuestionRepository questionRepository;


    private final ModelMapper mapper;

    public UUID CreateQuiz(QuizPostDTO quizPostDTO) {
        UUID id = UUID.randomUUID();

        Quiz quiz = mapper.map(quizPostDTO.getQuizDTO(), Quiz.class);

        var questionsAdd = quizPostDTO.getQuestionsDTO()
                        .stream()
                .map(questionDTO -> mapper.map(questionDTO, Question.class))
                        .collect(Collectors.toList());

        quiz.setQuestions(questionsAdd);
//        questionRepository.saveAll(questionsAdd);

        quizRepository.save(quiz);
        return id;
    }

//    public UUID CreateQuiz(QuizDTO quizDTO, List<QuestionDTO> questionDTOList) {
//        UUID id = UUID.randomUUID();
//
//        var quizAdd = mapper.map(quizDTO, Quiz.class);
//        var questionAdd = mapper.map(questionDTOList, Question.class);
//
//        quizAdd.setQuiz_id(id);
//
//        quizAdd.setQuestions(questionDTOList.stream().map(question -> mapper.map(question, Question.class))
//                .collect(Collectors.toList()));
//
////        questionAdd.set(questionDTOList.stream().map(
////                questionDTO -> mapper.map(questionDTO, QuestionDTO.class))
////                .collect(Collectors.toList());
////        ));
//
//        return id;
//    }
//    public UUID CreateQuiz(QuizDTO quizDTO, List<QuestionDTO> questionDTOList) {
//        UUID id = UUID.randomUUID();
//
//        Quiz quiz = mapper.map(quizDTO, Quiz.class);
//        quiz.setQuiz_id(id);
//        quiz.setQuestions(questionDTOList.stream().map(questionDTO -> {
//            Question question = new Question();
//            question.setQuestion(questionDTO.getQuestion());
//            question.setAnswer1(questionDTO.getAnswer1());
//            question.setAnswer2(questionDTO.getAnswer2());
//            question.setAnswer3(questionDTO.getAnswer3());
//            question.setAnswer4(questionDTO.getAnswer4());
//            question.setCorrectAnswer(questionDTO.getCorrectAnswer());
//            questionRepository.save(question);
//            return question;
//        }).collect(Collectors.toList()));
//
//        quizRepository.save(quiz);
//        return id;
//    }

//    public Quiz createQuiz(String name, List<String> questionTexts) {
//        Quiz quiz = new Quiz();
//        quiz.setId(UUID.randomUUID().toString());
//        quiz.setName(name);
//        quiz.setQuestions(questionTexts.stream()
//                .map(text -> {
//                    Question question = new Question();
//                    question.setId(UUID.randomUUID().toString());
//                    question.setText(text);
//                    question.setQuiz(quiz);
//                    return question;
//                })
//                .collect(Collectors.toList()));
//        return quizRepository.save(quiz);
//    }


}
