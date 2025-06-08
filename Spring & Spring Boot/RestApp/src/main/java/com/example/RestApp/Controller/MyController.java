package com.example.RestApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  
@RequestMapping("/")
public class MyController {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!!";
	}
	
	@GetMapping("/bonjour")
	public String sayBonjour() {
		return "Bonjour Le Monde!!";
	}
	
	@GetMapping("/bye")
	public String sayBye() {
		return "BBye!!";
	}
}