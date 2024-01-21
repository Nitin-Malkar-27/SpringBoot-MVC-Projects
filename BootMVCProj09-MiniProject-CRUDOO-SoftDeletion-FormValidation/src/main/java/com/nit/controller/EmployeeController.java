package com.nit.controller;

import java.awt.print.Pageable;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nit.EmployeeValidator;
import com.nit.model.Employee;
import com.nit.service.IEmployeeMgmtService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeMgmtService service;

	@Autowired
	private EmployeeValidator validator;

	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}

	/*@GetMapping("/emp_report")
	public String showEmployeeReport(Map<String, Object> map) {
		// use service
		Iterable<Employee> empList = service.getAllEmployees();
		// keep result as model attribute
		map.put("empList", empList);
	
		// return LVN
		return "employee_report";
	}*/

	@GetMapping("/emp_report")
	public String showEmployeeReport(
			@PageableDefault(page = 0, size = 3, sort = "empno", direction = Direction.ASC) Pageable pageable,
			Map<String, Object> map) {
		// use service
		Iterable<Employee> page = service.getEmployeesPageDate(pageable);
		// keep result as model attribute
		map.put("pageData", page);

		// return LVN
		return "employee_report";
	}

	@GetMapping("/insert_employee")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {

		// return LVN
		return "add_employee";
	}

	/*@PostMapping("/insert_employee")
	String insertEmployee(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
	
		// use service
		String result = service.insertEmployee(emp);
		Iterable<Employee> empList = service.getAllEmployees();
	
		// add result to model attribute
		map.put("resultMsg", result);
		map.put("empList", empList);
	
		// LVN
		return "employee_report";
	}*/

	// Solving the reposting (insert Multiple data) problem

	@PostMapping("/insert_employee")
	String insertEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp, BindingResult errors) {

		// enable server side form validations only when client side form validations
		// are not done
		if (emp.getVflag().equalsIgnoreCase("no")) {
			// form validation error logics
			if (validator.supports(emp.getClass())) {
				validator.validate(emp, errors);
				if (errors.hasErrors())
					return "add_employee";
			}
		}

		// Application/business logic errors
		if (emp.getJob().equalsIgnoreCase("PRESIDENT") || emp.getJob().equalsIgnoreCase("QUEEN")) {
			errors.rejectValue("job", "e.job.restriction");
			return "add_employee";
		}
		// use service
		String result = service.insertEmployee(emp);

		// add result to model attribute
		attrs.addFlashAttribute("resultMsg", result);

		// LVN
		return "redirect:emp_report";
	}

	@GetMapping("/edit_employee")
	public String showEditEmployeeFromPage(@RequestParam("eno") int no, @ModelAttribute("emp") Employee emp) {

		// use service
		Employee emp1 = service.getEmployeeById(no);
		BeanUtils.copyProperties(emp1, emp);
		// return LVN
		return "modify_employee";
	}

	/*@PostMapping("edit_employee")
	public String eidtEmployee(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
	
		// use service
		String result = service.updateEmployee(emp);
		Iterable<Employee> empList = service.getAllEmployees();
		// keeps results in model attributes
		map.put("empList", empList);
		map.put("resultMsg", result);
	
		// return LVN
		return "employee_report";
	}*/

	// solving double posting problem
	@PostMapping("edit_employee")
	public String eidtEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp, BindingResult errors) {

		// enable server side form validations only when client side form validations
		// are not done
		if (emp.getVflag().equalsIgnoreCase("no")) {
			// form validation errors logics
			if (validator.supports(emp.getClass())) {
				validator.validate(emp, errors);

				if (errors.hasErrors())
					return "modify_employee";
			}
		}

		// application/ business logics errors
		if (emp.getJob().equalsIgnoreCase("PRESIDENT") || emp.getJob().equalsIgnoreCase("QUEEN")) {
			errors.rejectValue("job", "e.job.restriction");
			return "modify_employee";
		}
		// use service
		String result = service.updateEmployee(emp);

		// keeps results in model attributes
		attrs.addFlashAttribute("resultMsg", result);

		// return LVN
		return "redirect:emp_report";
	}

	/*@GetMapping("delete_employee")
	public String deleteEmployee(Map<String, Object> map, @RequestParam("eno") int no) {
	
		// use service
		String result = service.deleteEmployee(no);
		Iterable<Employee> empList = service.getAllEmployees();
		// keep result in model attribute
		map.put("empList", empList);
		map.put("resultMsg", result);
	
		return "employee_report";
	}*/

	// solving double posting problem

	@GetMapping("delete_employee")
	public String deleteEmployee(RedirectAttributes attrs, @RequestParam("eno") int no) {

		// use service
		String result = service.deleteEmployee(no);
		// keep result in model attribute
		attrs.addFlashAttribute("resultMsg", result);

		return "redirect:emp_report";
	}

}
