package com.example.rest.controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.entity.Student;
import com.example.rest.entity.StudentErrorResponse;

import exceptions.StudentNotFoundException;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	List<Student> students = new ArrayList<Student>();
	
	@PostConstruct //this method will be executed only once! no need to call
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
		
		if((studentID >= students.size()) || studentID < 0) {
			throw new StudentNotFoundException("Student ID not found - "+studentID);
		}
		
		return students.get(studentID);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
}
