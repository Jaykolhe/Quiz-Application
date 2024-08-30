package com.jay.Quiz_App.Dao;

import com.jay.Quiz_App.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
