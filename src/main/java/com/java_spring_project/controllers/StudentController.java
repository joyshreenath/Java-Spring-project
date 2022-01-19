package com.java_spring_project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

//import com.java_spring_project.DAO.StudentDAO;
import com.java_spring_project.api.Student;
import com.java_spring_project.service.StudentService;
//import com.java_spring_project.api.StudentDTO;


@Controller
public class StudentController {
	
	//@Autowired
	//private StudentDAO StudentDAO; 
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/showStudent")
	public String showStudentList(Model model) {
		List<Student> studentList = studentService.loadStudents();
		
		//for(Student tempStudent : studentList) {
			//System.out.println(tempStudent);
	   // }
		
		model.addAttribute("students", studentList);
		return "student-list";
	}
	@GetMapping("/showAddStudentPage")
	 public String addstudent(Model model) {
		Student student = new Student();
		
		model.addAttribute("student", student);
		return "add-student";
	}
	
	@PostMapping("/save-student")
	public String saveStudent(Student student) {
		System.out.println(student);
		
		//studentService.saveStudent(student);
		//If the user doesn't have an id value go for insert operaton else if user has an id value then go for update operation
		if(student.getId()==0) {
			studentService.saveStudent(student);
			}
		else {
			studentService.update(student);
		}
		return "redirect:/showStudent";
		//return "process-email-page";
	}
	
	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int id, Model model) {
		System.out.println("looking data for the student having id : "+ id);
		Student theStudent = studentService.getStudent(id);
		model.addAttribute("student", theStudent);
	 //public String updateStudent(@RequestParam("userId") int id, @ModelAttribute("student") Student student) {
	
		//Student theStudent = studentService.getStudent(id);
		//student.setId(theStudent.getId());
		//student.setName(theStudent.getName());
		//student.setMobile(theStudent.getMobile());
		//student.setCountry(theStudent.getCountry());
		return "add-student";
	}
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int id) {
		
		Student theStudent = studentService.getStudent(id);
	//capture the id of student you want to delete
		//once catured id, do a service call to delete the student
		studentService.deleteStudent(id);
		//	model.addAttribute("student", theStudent);
	 
		return "redirect:/showStudent";
	}
	//@ResponseBody
	//@GetMapping("/thankyou")
	//public String thankYou() {
	//	return "Thank You... Your record has been added to the database";
	//}


}


