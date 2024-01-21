package com.nit.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nit.model.Employee;

@Controller
public class TestController {

	@GetMapping("/report")
	public String showReport(Map<String, Object> map) {

		// add model attributes (simple values)
		map.put("name", "raja");
		map.put("age", 40);
		map.put("addrs", "hyd");

		// =======Arrays and Collection values====================
		String nickNames[] = new String[] { "raja", "jani", "suresh", "mangesh" };
		Set<Long> mobilePhonesSet = new HashSet();
		mobilePhonesSet.add(9999999l);
		mobilePhonesSet.add(888888888l);
		mobilePhonesSet.add(777777777l);

		List<String> courseList = List.of("java", "spring", "j2ee", "springBoot");
		Map<String, Long> idsMap = Map.of("aadhar", 3434343l, "voterid", 34534353535l, "panNo", 345345353555l);

		// create Model atttributes
		map.put("nicknames", nickNames);
		map.put("phonesInfo", mobilePhonesSet);
		map.put("courseInfo", courseList);
		map.put("idsInfo", idsMap);

		// ==========Model object value==================
		List<Employee> empList = List.of(new Employee(101, "raja", "clerk", 45000.0),
				new Employee(102, "sonu", "developer", 34340.0));

		map.put("empsInfo", empList);

		// LVN Name
		return "show_report";

	}
}
