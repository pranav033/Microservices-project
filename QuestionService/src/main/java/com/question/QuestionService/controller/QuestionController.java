package com.question.QuestionService.controller;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.services.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {


    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/addquestion")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        Question addedQuestion = questionService.addQuestion(question);
        return ResponseEntity.ok(addedQuestion);
    }

    @GetMapping("/getonequestion/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Question question = questionService.getOneQuestion(id);
        return ResponseEntity.ok(question);

    }

    @GetMapping("/getallquestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> allQuestions = questionService.getAllQuestions();
        return ResponseEntity.ok(allQuestions);
    }

    @GetMapping("/getallbyquizid/{quizId}")
    public ResponseEntity<List<Question>> getAllQuestionsByQuizId(@PathVariable Long quizId) {
        List<Question> questionList = questionService.getByQuizId(quizId);
        return ResponseEntity.ok(questionList);
    }
}
