package com.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.feign.Feigninterface;
import com.quiz.model.Question;
import com.quiz.model.Questionwrapper;
import com.quiz.model.Quiz;
import com.quiz.model.Response;
import com.quiz.repository.Quizrepo;

@Service
public class Quizservice {
	
	@Autowired
	private Quizrepo repo;
	@Autowired
	private Feigninterface feign1;
		
	public ResponseEntity<String> createQuiz(String category, int numq, String title) {
		List<Integer> question = feign1.createquiz(category, numq).getBody();
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(question);
		repo.save(quiz);
		
		return new ResponseEntity<>("sucses",HttpStatus.OK);
	
	}
	public ResponseEntity<List<Questionwrapper>> generateQuiz(int id) {
		
		Quiz quiz=repo.findById(id).get();
		ResponseEntity<List<Questionwrapper>> questions=feign1.getquestions(quiz.getQuestions());
		return questions;
	}

	public ResponseEntity<Integer> calculation(int id, List<Response> responses) {
		Integer score=feign1.getscore(responses).getBody();
		return new ResponseEntity<>(score,HttpStatus.OK);
	}
}
