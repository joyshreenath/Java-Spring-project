package com.java_spring_project.DAO;

import java.util.List;

import com.java_spring_project.api.Student;

public interface StudentDAO {
	List<Student> loadStudents();
	void saveStudent(Student student);
	Student getStudent(int id);
	void update(Student student);
	void deleteStudent(int id);
	

}
