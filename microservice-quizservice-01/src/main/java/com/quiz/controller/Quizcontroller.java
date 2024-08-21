package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.model.Createquiz;
import com.quiz.model.Questionwrapper;
import com.quiz.model.Response;
import com.quiz.service.Quizservice;

@RestController
@RequestMapping("quiz")
public class Quizcontroller {
	
	@Autowired
	private Quizservice service;
	
	@PostMapping("create")
	public ResponseEntity<String> create(@RequestBody Createquiz createquiz){
		return service.createQuiz(createquiz.getCategory(),createquiz.getNumq(),createquiz.getTitle()); 
	}
	
	@GetMapping("quiz/{id}")
	public ResponseEntity<List<Questionwrapper>> generateQuiz(@PathVariable int id){
		return (ResponseEntity<List<Questionwrapper>>) service.generateQuiz(id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> calculation(@PathVariable int id,@RequestBody List<Response> responses){
		return service.calculation(id,responses);
		
	}

}
