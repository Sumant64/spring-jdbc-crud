package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private JdbcTemplate myjdbcTemplate;

	public int insert(Student student) {
		//insert query
		String query = "insert into student(id, name, city) values (?, ?, ?)";
		int r = this.myjdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return r;
	}

	public JdbcTemplate getMyjdbcTemplate() {
		return myjdbcTemplate;
	}

	public void setMyjdbcTemplate(JdbcTemplate myjdbcTemplate) {
		this.myjdbcTemplate = myjdbcTemplate;
	}

	public int change(Student student) {
		// updating data
		String query = "update student set name=?, city=? where id=?";
		int r = this.myjdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return r;
	}

	public int delete(int studentId) {
		// delete operation
		String query = "delete from student where id = ?";
		int r = this.myjdbcTemplate.update(query, studentId);
		
		return r;
	}

	public Student getStudent(int studentId) {
		// select single student data
		String query = "select * from student where id =?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.myjdbcTemplate.queryForObject(query, rowMapper, studentId);
		
		return student;
	}

	public List<Student> getAllStudents() {
		// get all students
		String query = "select * from student";
		List<Student> students = this.myjdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}


	
	
}
