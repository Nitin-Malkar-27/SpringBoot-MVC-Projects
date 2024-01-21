package com.nit.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nit.editor.LocalDateEditor;
import com.nit.editor.LocalDateTimeEditor;
import com.nit.editor.LocalTimeEditor;
import com.nit.model.Cricketer;
import com.nit.service.ICricketerMgmtService;

@Controller
public class CricketerController {

	@Autowired
	private ICricketerMgmtService service;

	@GetMapping("/")
	public String showHomePage() {

		return "home";
	}

	@GetMapping("/register")
	public String showCricketerRegistrationPage(@ModelAttribute("cktr") Cricketer cktr) {
		return "cricketer_register";
	}

	@PostMapping("/register")
	public String registerCricketer(Map<String, Object> map, @ModelAttribute("cktr") Cricketer cktr,
			BindingResult error) {

		if (error.hasErrors()) {
			return "cricketer_register";
		}

		// use serivce
		String msg = service.registerCricketer(cktr);

		// keep result a Model Attribute
		map.put("resultMsg", msg);

		// LVN
		return "show_result";
	}

	@InitBinder
	public void myInitBinder(WebDataBinder binder) {
		System.out.println("CricketerController.myInitBinder()");

		binder.registerCustomEditor(LocalDate.class, new LocalDateEditor());
		binder.registerCustomEditor(LocalTime.class, new LocalTimeEditor());
		binder.registerCustomEditor(LocalDateTime.class, new LocalDateTimeEditor());
	}
}