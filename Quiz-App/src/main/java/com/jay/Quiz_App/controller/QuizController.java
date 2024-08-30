package com.jay.Quiz_App.controller;

import com.jay.Quiz_App.Entity.Question;
import com.jay.Quiz_App.Entity.QuestionWrapper;
import com.jay.Quiz_App.Entity.Response;
import com.jay.Quiz_App.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ , @RequestParam String title){
        quizService.createQuiz(category,numQ,title);
        return new ResponseEntity<>("I am Doing", HttpStatus.CREATED);

    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){

        return quizService.getQuizQuestions(id);

    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){

        return  quizService.calculateResult(id,responses);



    }



}
