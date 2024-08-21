package com.question.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.question.model.Question;
import com.question.model.Questionwrapper;
import com.question.model.Response;
import com.question.repository.Questionrepository;


@Service
public class Questionservice {
	
	@Autowired
	private Questionrepository repo;
	
	@Autowired
	Environment environment;
	
	public String addquestion(Question question) {
		
		repo.save(question);
		return "sucsess";
	}


	public ResponseEntity<List<Question>> allquestions() {
		try {
		return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}


	public List<Question> findbycategory(String category) {
		List<Question> q = repo.findByCategory(category);
		return q;
	}


	public ResponseEntity<List<Integer>> createquiz(String category, int numq) {
		List<Integer> questions = repo.CreateQuizByCategory(category,numq);
		return new ResponseEntity<>(questions,HttpStatus.OK);
	}


	public ResponseEntity<List<Questionwrapper>> getquestions(List<Integer> questionids) {
		List<Questionwrapper> wrappers = new ArrayList<>();
		List<Question> questions = new ArrayList<>();
		for(Integer id:questionids) {
			questions.add(repo.findById(id).get());
		}
		for(Question question:questions) {
			Questionwrapper wrapper = new Questionwrapper();
			wrapper.setId(question.getId());
			wrapper.setQuestion(question.getQuestion());
			wrapper.setOption1(question.getOption1());
			wrapper.setOption2(question.getOption2());
			wrapper.setOption3(question.getOption3());
			wrapper.setOption4(question.getOption4());
			wrappers.add(wrapper);
		}
		System.out.println(environment.getProperty("local.server.port"));
		return new ResponseEntity<>(wrappers,HttpStatus.OK);
	}


	public ResponseEntity<Integer> getscore(List<Response> responses) {
		int rightanswer=0;
		for(Response response:responses) {
			Question questions=repo.findById(response.getId()).get();
			if(response.getResponse().equals(questions.getCorrectanswer()))
			rightanswer++;
			
		}
		return new ResponseEntity<>(rightanswer,HttpStatus.OK);
	}


	

}
