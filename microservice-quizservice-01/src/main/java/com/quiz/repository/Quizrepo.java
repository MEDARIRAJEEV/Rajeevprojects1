package com.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.quiz.model.Quiz;

public interface Quizrepo extends JpaRepository<Quiz, Integer> {

}
