package com.sathya.controller;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.sathya.model.Students;
import com.sathya.repo.StudentRepository;
import com.sathya.service.StudentServiceimp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentController {
	
	@Autowired
	private StudentServiceimp service;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	@RequestMapping("/register")
	public String addStudent() {
		return "register";
	}
	@RequestMapping("/save")
	public String regStudent(Students students) {
		Students s= service.saveStudent(students);
		return "savestudent";
	}
	@RequestMapping("/viewstudents")
	public String viewstudents(ModelMap m) {
		m.put("Students",service.getAllStudent());
		return "view";
		
	}
	@RequestMapping("/delete/{rollnumber}")
	public String delete(@PathVariable int rollnumber,ModelMap M) 
	{
		service.deleteStudent(rollnumber);
		return "redirect:/viewstudents";
	}
	@RequestMapping("/update/{rollnumber}")
	public String edit(@PathVariable int rollnumber,ModelMap m) {
		m.put("command", service.getStudent(rollnumber));
		
		return "edit";
	}
	@RequestMapping("/editandsave")
	public String saveedit(Students students) {
		Students edit = service.updateStudent(students);
		
		return "redirect:/viewstudents";
	}
	
	
	
}
