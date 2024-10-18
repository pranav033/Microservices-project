package com.quiz.QuizService.controllers;

import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.services.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/addquiz")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
        Quiz addedQuiz = quizService.addQuiz(quiz);
        return ResponseEntity.ok(addedQuiz);
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<Quiz> getOneQuiz(@PathVariable Long id) {
        Quiz quiz = quizService.getQuizById(id);
        return ResponseEntity.ok(quiz);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Quiz>> getAllQuiz() {
        List<Quiz> quizList = quizService.getAllQuiz();
        return ResponseEntity.ok(quizList);
    }
}
