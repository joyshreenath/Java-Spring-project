package com.java_spring_project.service;

import java.util.List;

import com.java_spring_project.api.Student;

public interface StudentService {
	List<Student> loadStudents();

	void saveStudent(Student student);
	
	Student getStudent(int id);

	void update(Student student);

	void deleteStudent(int id);


}
