package com.nit.service;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;

import com.nit.model.Employee;

public interface IEmployeeMgmtService {

	public Iterable<Employee> getAllEmployees();

	public Page<Employee> getEmployeesPageDate(Pageable pageable);

	public String insertEmployee(Employee emp);

	public Employee getEmployeeById(int eno);

	public String updateEmployee(Employee emp);

	public String deleteEmployee(int eno);

}
