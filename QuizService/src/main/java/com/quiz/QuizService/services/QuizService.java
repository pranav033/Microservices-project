package com.quiz.QuizService.services;

import com.quiz.QuizService.entities.Quiz;

import java.util.List;

public interface QuizService {

    Quiz addQuiz(Quiz quiz);

    List<Quiz> getAllQuiz();

    Quiz getQuizById(Long id);


}
