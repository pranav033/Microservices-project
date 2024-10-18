package com.quiz.QuizService.services.impl;

import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.repository.QuizRepository;
import com.quiz.QuizService.services.QuestionClient;
import com.quiz.QuizService.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;

    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz addQuiz(Quiz quiz) {
        Quiz savedQuiz = quizRepository.save(quiz);
        return savedQuiz;
    }

    @Override
    public List<Quiz> getAllQuiz() {
        List<Quiz> quizzes = quizRepository.findAll();
        List<Quiz> quizList = quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionsofQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return quizList;
    }

    @Override
    public Quiz getQuizById(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionsofQuiz(quiz.getId()));
        return quiz;
    }
}
