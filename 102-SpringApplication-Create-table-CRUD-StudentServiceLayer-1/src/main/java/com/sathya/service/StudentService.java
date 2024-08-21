package com.sathya.service;

import java.util.List;

import com.sathya.model.Students;

public interface StudentService {
	
	public Students saveStudent(Students students);
	public Students updateStudent(Students students);
	public void deleteStudent(int Rollnumber);
	public Students getStudent(int Rollnumber);
	public List<Students>getAllStudent();
}
