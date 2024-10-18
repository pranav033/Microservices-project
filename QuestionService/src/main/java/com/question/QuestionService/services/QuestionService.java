package com.question.QuestionService.services;

import com.question.QuestionService.entities.Question;

import java.util.List;

public interface QuestionService {

    Question getOneQuestion(Long id);

    Question addQuestion(Question question);

    List<Question> getAllQuestions();

    List<Question> getByQuizId(Long quizId);
}
