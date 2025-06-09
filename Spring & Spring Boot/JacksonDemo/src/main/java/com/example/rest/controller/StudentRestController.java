package com.example.rest.controller;

import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	List<Student> students = new ArrayList<Student>();
	
	@PostConstruct //this method will be executed only once!	
	private void loadStudents() {
        students.add(new Student("Harry", "Potter"));
        students.add(new Student("Hermione", "Granger"));
        students.add(new Student("Ron", "Weasley"));
        students.add(new Student("Neville", "Longbottom"));
        students.add(new Student("Draco", "Malfoy"));
    }
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return students;
	}
	
	@GetMapping("/students/{studentID}")
	public Student getStudent(@PathVariable int studentID) {
		
		return students.get(studentID);
	}
}
