package com.sathya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sathya.model.Students;
import com.sathya.repo.StudentRepository;

@Service
public class StudentServiceimp implements StudentService {
	@Autowired
	private StudentRepository repo;

	@Override
	public Students saveStudent(Students students) {// TODO Auto-generated method stub
	int tot=0;
	double p=0.0;
	String g=null,r=null;
	tot=students.getHibernate()+students.getSpring()+students.getSpringboot();
	p=tot/3;
	if((p>=70)&&(students.getHibernate()>=35&&students.getSpring()>=35&&students.getSpringboot()>=35))
	{
		g="A grade";
		r="Pass";
	}
	if((p>=70)&&(students.getHibernate()<35||students.getSpring()<35||students.getSpringboot()<35))
	{
		g="A grade";
		r="Fail";
	}
	if((p>=60&&p<70)&&(students.getHibernate()>=35&&students.getSpring()>=35&&students.getSpringboot()>=35))
	{
		g="B grade";
		r="Pass";
	}
	if((p>=60&&p<70)&&(students.getHibernate()<35||students.getSpring()<35||students.getSpringboot()<35))
	{
		g="B grade";
		r="Fail";
	}
	if((p>=50&&p<60)&&(students.getHibernate()>=35&&students.getSpring()>=35&&students.getSpringboot()>=35))
	{
		g="C grade";
		r="Pass";
	}
	if((p>=50&&p<60)&&(students.getHibernate()<35||students.getSpring()<35||students.getSpringboot()<35))
	{
		g="C grade";
		r="Fail";
	}
	
	students.setTotal(tot);
	students.setPercentage(p);
	students.setResult(r);
	students.setGrade(g);
	Students sa = repo.save(students);
	return sa;
	
	
	
}
@Override
public List<Students> getAllStudent() {
	// TODO Auto-generated method stub
	List<Students> allstudents = repo.findAll();
	return allstudents;
}


	@Override
	public Students updateStudent(Students students) {
		// TODO Auto-generated method stub
		int tot=0;
		double p=0.0;
		String g=null,r=null;
		tot=students.getHibernate()+students.getSpring()+students.getSpringboot();
		p=tot/3;
		if((p>=70)&&(students.getHibernate()>=35&&students.getSpring()>=35&&students.getSpringboot()>=35))
		{
			g="A grade";
			r="Pass";
		}
		if((p>=70)&&(students.getHibernate()<35||students.getSpring()<35||students.getSpringboot()<35))
		{
			g="A grade";
			r="Fail";
		}
		if((p>=60&&p<70)&&(students.getHibernate()>=35&&students.getSpring()>=35&&students.getSpringboot()>=35))
		{
			g="B grade";
			r="Pass";
		}
		if((p>=60&&p<70)&&(students.getHibernate()<35||students.getSpring()<35||students.getSpringboot()<35))
		{
			g="B grade";
			r="Fail";
		}
		if((p>=50&&p<60)&&(students.getHibernate()>=35&&students.getSpring()>=35&&students.getSpringboot()>=35))
		{
			g="C grade";
			r="Pass";
		}
		if((p>=50&&p<60)&&(students.getHibernate()<35||students.getSpring()<35||students.getSpringboot()<35))
		{
			g="C grade";
			r="Fail";
		}
		
		students.setTotal(tot);
		students.setPercentage(p);
		students.setResult(r);
		students.setGrade(g);
		Students sa = repo.save(students);
		return sa;
	}

	@Override
	public void deleteStudent(int Rollnumber) {
		// TODO Auto-generated method stub
		repo.deleteById(Rollnumber);
		
		
	}

	@Override
	public Students getStudent(int Rollnumber) {
		Students student=repo.findById(Rollnumber).get();
		return student;
	}

	
	

	
	
	

}
