package com.keshaw.SpringJDBC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keshaw.SpringJDBC.Model.Student;
import com.keshaw.SpringJDBC.Repository.StudentRepo;

@Service
public class StudentService {

	private StudentRepo repo;
	
		
	public StudentRepo getRepo() {
		return repo;
	}

	@Autowired
	public void setRepo(StudentRepo repo) {
		this.repo = repo;
	}

	public void addStudent(Student s) {
		repo.save(s);
	}
	
	public List<Student> getStudents(Student s) {
		return repo.findAll();
	}

}
