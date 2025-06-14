package com.example.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

	@GetMapping("/emps")
	public String getEmployee() {
		Employee emp = new Employee("Harry J. Potter", "1"); //using constructor generated by lombok
		return emp.getId()+" "+emp.getName(); // using getter method generated by lombok
	}	
	
}
