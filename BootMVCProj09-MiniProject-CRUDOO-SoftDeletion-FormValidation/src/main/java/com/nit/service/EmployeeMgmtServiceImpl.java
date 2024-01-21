package com.nit.service;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nit.model.Employee;
import com.nit.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepo empRepo;

	@Override
	public Iterable<Employee> getAllEmployees() {
		return empRepo.findAll(Sort.by("job").ascending());
	}

	@Override
	public String insertEmployee(Employee emp) {

		return " Employee inserted with id value:: " + empRepo.save(emp).getEmpno();
	}

	@Override
	public Employee getEmployeeById(int eno) {

		return empRepo.findById(eno).get();
	}

	@Override
	public String updateEmployee(Employee emp) {

		return empRepo.save(emp).getEmpno() + " Employee updated";
	}

	@Override
	public String deleteEmployee(int eno) {
		empRepo.deleteById(eno);
		return eno + " employee number deleted";
	}

	@Override
	public Page<Employee> getEmployeesPageDate(Pageable pageable) {

		return  empRepo.findAll( pageable);

	}
}
