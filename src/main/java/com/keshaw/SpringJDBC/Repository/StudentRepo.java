package com.keshaw.SpringJDBC.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.keshaw.SpringJDBC.Model.Student;

@Repository
public class StudentRepo {
	
	private JdbcTemplate jdbc;
	
	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	@Autowired
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void save(Student s) {
		String sql = "insert into student(rollno,name,marks) values(?,?,?)";
		int value = jdbc.update(sql,s.getRollNo(),s.getName(),s.getMarks());
		System.out.println(value + " effected ::");
	}

	public List<Student> findAll() {
		
		List<Student> list = new ArrayList<>();
		System.out.println("Findall called::");
		
		String sql = "select * from student";
		
		RowMapper<Student> mapper = new RowMapper<Student>() {
			
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

				Student s = new Student();
				s.setRollNo(rs.getInt("rollno"));
				s.setName(rs.getString("name"));
				s.setMarks(rs.getInt("marks"));
				
				return s;
			}
		};
		return jdbc.query(sql, mapper);
		
//		return jdbc.query(sql, (ResultSet rs, int rowNum) -> {
//
//			Student s = new Student();
//			s.setRollNo(rs.getInt("rollno"));
//			s.setName(rs.getString("name"));
//			s.setMarks(rs.getInt("marks"));
//			
//			return s;
//		});
	}

}
