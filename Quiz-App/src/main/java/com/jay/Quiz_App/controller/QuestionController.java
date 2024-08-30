package com.jay.Quiz_App.controller;


import com.jay.Quiz_App.Entity.Question;
import com.jay.Quiz_App.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {


    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("Category/{category}")
    public List<Question> getAllQuestionsByCategory(@PathVariable String category){
        return questionService.getAllQuestionsByCategory(category);

    }
    @PostMapping("addQuestion")
    public String addQuestion(@RequestBody Question question){

        System.out.println("Question Added");
        questionService.addQuestion(question);
        return "Question Added Successfully";
    }

    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable Integer id){

        questionService.deleteById(id);
        System.out.println("Deleted Entry");
        return "Deleted Data Successfully";
    }

    @DeleteMapping("category/{category}")
    public String deletedByCategory(@PathVariable String category){
        questionService.deletedByCategory(category);
        System.out.println("Deleted Category");
        return "Deleted Category Successfully";
    }
}
