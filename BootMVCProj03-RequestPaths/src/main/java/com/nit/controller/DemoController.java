package com.nit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private ServletContext sc;

	@Autowired
	private ServletConfig scg;

	@Autowired
	private HttpSession ses;

	@RequestMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("report")
	// @RequestMapping(value = "/report", method = RequestMethod.GET)
	public String showReport(Map<String, Object> map) {
		System.out.println("DemoController.showReport(-)");

		System.out.println("web app name:: " + sc.getContextPath());
		System.out.println("Ds logical name: " + scg.getServletName());
		System.out.println("Session id: " + ses.getId());
		return "display";
	}

	@PostMapping("report")
	// @RequestMapping(value = "/report", method = RequestMethod.POST)
	public String showRepost1(Map<String, Object> map) {
		System.out.println("DemoController.showRepost1()");
		return "display1";
	}
}
