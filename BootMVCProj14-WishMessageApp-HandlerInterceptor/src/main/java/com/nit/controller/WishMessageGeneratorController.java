package com.nit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nit.service.IWishMessageService;

@Controller
public class WishMessageGeneratorController {

	@Autowired
	private IWishMessageService service;

	@RequestMapping("/")
	public String showHomePage() {
		System.out.println("WishMessageGeneratorController.showHomePage()");

		return "home";
	}
	/*
		@RequestMapping("/wish")
		public ModelAndView generateMessage() {
	
			// use service class
			String result = service.generateMessage();
	
			// return MAV
			ModelAndView mav = new ModelAndView();
			mav.addObject("wMsg", result); // like this can any no.of model attributes
			mav.setViewName("display");
			return mav;
		}*/

	/*@RequestMapping("/wish")
	public String generateMessage(BindingAwareModelMap map) {
	
		System.out.println("SharedMemory obj class name:: " + map.getClass());
	
		// use service
		String result = service.generateMessage();
		map.addAttribute("wMsg", result);
		// return LVN
		return "display";
	}
	*/

	// OR

	/*@RequestMapping("/wish")
	public String generateMessage(ModelMap map) {
		System.out.println("SharedMemory obj class name:: " + map.getClass());
	
		// use service
		String result = service.generateMessage();
		map.addAttribute("wMsg", result);
		// return LVN
		return "display";
	}*/

	/*@RequestMapping("/wish")
	public String generateMessage(HashMap<String, Object> map) {
		System.out.println("SharedMemory obj class name:: " + map.getClass());
	
		// use service
		String result = service.generateMessage();
		map.put("wMsg", result);
		return "display";
	}*/

	// OR

	@RequestMapping("/wish") // Recomanded
	public String generateMessage(Map<String, Object> map) {
		System.out.println("SharedMemory obj class name:: " + map.getClass());

		// use service
		String result = service.generateMessage();
		map.put("wMsg", result);
		return "display";
	}

}
