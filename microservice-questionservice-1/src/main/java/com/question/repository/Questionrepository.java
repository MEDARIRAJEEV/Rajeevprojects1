package com.question.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.question.model.Question;

@Repository
public interface Questionrepository extends JpaRepository<Question, Integer> {

	List<Question> findByCategory(String category);

	 @Query(value = "SELECT q.id FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numq", nativeQuery = true)
	  List<Integer> CreateQuizByCategory(String category, int numq);


}
