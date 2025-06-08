package com.example.rest.controller;

import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Harry","Potter"));
		students.add(new Student("Hermione","Granger"));
		students.add(new Student("Ron","Weasley"));
		students.add(new Student("Neville","Longbottom"));
		students.add(new Student("Draco","Malfoy"));
		return students;
	}
}
