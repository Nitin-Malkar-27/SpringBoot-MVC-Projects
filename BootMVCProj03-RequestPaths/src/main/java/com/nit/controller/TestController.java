package com.nit.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("report")
	// @RequestMapping(value = "/report", method = RequestMethod.GET)
	public String showReport(Map<String, Object> map) {
		System.out.println("TestController.showReport(-)");
		return "display";
	}

	@PostMapping("report")
	// @RequestMapping(value = "/report", method = RequestMethod.POST)
	public String showRepost1(Map<String, Object> map) {
		System.out.println("TestController.showRepost1()");
		return "display1";
	}
}
