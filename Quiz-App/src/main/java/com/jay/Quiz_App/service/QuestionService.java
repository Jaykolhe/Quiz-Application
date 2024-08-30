package com.jay.Quiz_App.service;


import com.jay.Quiz_App.Dao.QuestionDao;
import com.jay.Quiz_App.Entity.Question;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions() {

        return questionDao.findAll();
    }

    public List<Question> getAllQuestionsByCategory(String category) {

        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {

        questionDao.save(question);
        return "Question Added Successfully";
    }

    public void deleteById(Integer id) {
        questionDao.deleteById(id);

    }

    @Transactional
    public void deletedByCategory(String category) {
        questionDao.deleteByCategory(category);
    }
}
