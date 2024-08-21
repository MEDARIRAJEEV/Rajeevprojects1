package com.quiz.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.model.Questionwrapper;
import com.quiz.model.Response;
@FeignClient("microservice-questionservice-1")
public interface Feigninterface {
	@GetMapping("question/generate")
	public ResponseEntity<List<Integer>> createquiz(@RequestParam String category,@RequestParam int numq);
	
	@PostMapping("question/getquestions")
	public ResponseEntity<List<Questionwrapper>> getquestions(@RequestBody List<Integer> list);
	
	@PostMapping("question/getscore")
	public ResponseEntity<Integer> getscore(@RequestBody List<Response> responses);

}
