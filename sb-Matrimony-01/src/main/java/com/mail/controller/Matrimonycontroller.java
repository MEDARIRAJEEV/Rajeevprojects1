package com.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mail.model.Matrimony;
import com.mail.service.Matrimonyservice;

@Controller
public class Matrimonycontroller {
	
	@Autowired
	private Matrimonyservice service;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/register")
	public String Registeruser(@RequestParam String name,@RequestParam String mobileno,@RequestParam String job,@RequestParam String email,@RequestParam String password) {
		Matrimony matrimony=service.saveUser(name,mobileno,job,email,password);
		if(matrimony==null) {
			return "savefail";
		}
		else
		return "saveres";
	}
	
	@RequestMapping("/login")
	public String loginuser(@RequestParam String email,@RequestParam String password) {
		Matrimony m=service.login(email,password);
		
		return "verify";
		
	}
	
	@RequestMapping("/verify")
	public String verify(@RequestParam String email,@RequestParam String otp) {
		Matrimony m=service.verifyotp(email,otp);
		if(m==null) {
			return"loginfail";
		}
		else
		return "loginsuc";
	}
	
	@RequestMapping("/viewall")
	public String viewall(Model m) {
		m.addAttribute("a",service.viewusers());
		
		return "viewmem";
	}
	
	


}
