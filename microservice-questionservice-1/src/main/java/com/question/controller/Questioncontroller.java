package com.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.question.model.Question;
import com.question.model.Questionwrapper;
import com.question.model.Response;
import com.question.service.Questionservice;

@RestController
@RequestMapping("question")
public class Questioncontroller {
	
	@Autowired
	private Questionservice service;
	
	@PostMapping("add")
	public String savequestion(@RequestBody Question question) {
		
		return service.addquestion(question);
	}
	
	@GetMapping("getall")
	public ResponseEntity<List<Question>> getall() {
		return service.allquestions();
	}
	
	
	@GetMapping("category/{category}")
	public List<Question> getbycategory(@PathVariable String category){
		return service.findbycategory(category);
	}
	
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> createquiz(@RequestParam String category,@RequestParam int numq){
		return service.createquiz(category,numq);
	}
	
	@PostMapping("getquestions")
	public ResponseEntity<List<Questionwrapper>> getquestions(@RequestBody List<Integer> questionids){
		return service.getquestions(questionids);
	}
	
	@PostMapping("getscore")
	public ResponseEntity<Integer> getscore(@RequestBody List<Response> responses){
		return service.getscore(responses);
	}
	


}

