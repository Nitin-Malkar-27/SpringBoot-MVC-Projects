package com.nit.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nit.model.Employee;

@Controller
public class EmployeeController {

	@GetMapping("/")
	public String showHome() {

		return "home";
	}

	@GetMapping("/emp_register")
	public String showForm(@ModelAttribute("emp") Employee emp) {
		return "register";
	}

	@PostMapping("/emp_register")
	public String registerEmployee(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
		// read and use form data from model class object or send to service class
		System.out.println(emp);
		return "result";
	}

}
