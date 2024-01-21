package com.nit;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.nit.model.Employee;

@Component
public class EmployeeValidator implements org.springframework.validation.Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("Validator.supports()");

		// return Employee.class==clazz; whether handler method is passing

		return clazz.isAssignableFrom(Employee.class); // correct command class object or not
		// if passed internally calls validate(-,-) otherwise throws Exception

	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("Validator.validate()");
		// type casting
		Employee emp = (Employee) target;

		// server side form validation logic

		if (emp.getEname() == null || emp.getEname().isBlank()) { // required rule
			errors.rejectValue("ename", "emp.ename.required");

		} else if (emp.getEname().length() < 5) {
			errors.rejectValue("ename", "emp.ename.minlength"); // minlength rule
		}

		if (emp.getJob() == null || emp.getJob().isBlank()) {// reqired rule
			errors.rejectValue("job", "emp.job.required");
		} else if (emp.getJob().length() < 5) {// minlength rule
			errors.rejectValue("job", "emp.job.minlength");
		}

		if (emp.getSal() == null) {// required rule
			errors.rejectValue("sal", "emp.sal.required");

			// this logic gives predefined exception because it runs afters saving the data
			/*	} else if (emp.getSal().isNaN()) { // numeric rule
			errors.rejectValue("sal", "emp.sal.numeric");*/

		} else if (emp.getSal() < 10000 || emp.getSal() > 100000) {// range rule
			errors.rejectValue("sal", "emp.sal.range");
		}

		if (emp.getDeptno() == null) {// required rule
			errors.rejectValue("deptno", "emp.deptno.required");

			/*} else if (((Float) emp.getDeptno().floatValue()).isNaN()) { // numeric rule
				errors.rejectValue("deptno", "emp.deptno.numeric");*/

		} else if (emp.getDeptno() < 10 || emp.getDeptno() > 100) {// range rule
			errors.rejectValue("sal", "emp.deptno.range");
		}

	}

}
