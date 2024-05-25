package com.keshaw.SpringJDBC;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.keshaw.SpringJDBC.Model.Student;
import com.keshaw.SpringJDBC.Service.StudentService;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		
		Student s = context.getBean(Student.class);
		s.setRollNo(105); 
		s.setName("Telusko");
		s.setMarks(99);
		
		StudentService service = context.getBean(StudentService.class);
		//service.addStudent(s);
		
		List<Student> studentlist = service.getStudents(s);
		
		System.out.println(studentlist.toString());
	}

}
