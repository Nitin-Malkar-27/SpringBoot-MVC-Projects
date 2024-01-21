package com.nit.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataBindingController {

	/*	@GetMapping("/data")
		public String bindData(Map<String, Object> map, @RequestParam("sno") int no, @RequestParam("sname") String name) {
	
			System.out.println(no + " " + name);
			// LVN name
			return "show_data";
		}
		*/

	/*@GetMapping("/data")
	public String bindData(Map<String, Object> map, @RequestParam int sno, @RequestParam String sname) {
		System.out.println(sno + " " + sname);
		return "show_data";
	}
	*/

	/*// to make the "sname" presence int the request param
	@GetMapping("/data")
	public String bindData(Map<String, Object> map, @RequestParam int sno,
			@RequestParam(required = false) String sname) {
		System.out.println(sno + " " + sname);
		return "show_data";
	}*/
	/*// to take default value of request param
	@GetMapping("/data")
	public String bindData(Map<String, Object> map, @RequestParam int sno,
			@RequestParam(defaultValue = "raja") String sname) {
		System.out.println(sno + " " + sname);
		return "show_data";
	}*/

	// if one request param is having multiple values then we can store themn either
	// string[] or List/Set type
	@GetMapping("/data")
	public String bindData(Map<String, Object> map, @RequestParam int sno,
			@RequestParam(defaultValue = "raja") String[] sname, @RequestParam("sname") Set<String> names) {
		System.out.println(sno + " " + Arrays.toString(sname)+" " +names);
		return "show_data";
	}

}
