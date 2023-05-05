package com.example.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRepo;

	public String addEmployee(Employee emp) {
		empRepo.save(emp);
		return "Successfully Saved";
	}

	public Employee getEmployee(int id) {
		return empRepo.findById(id).get();

	}

	public String deleteEmployee(int id) {
		empRepo.deleteById(id);
		return "Successfully Deleted";
	}

	public String addEmployee(List<Employee> emp) {
		empRepo.saveAll(emp);
		return "Successfully Saved";
	}

	public List<Employee> getEmployee() {
		return empRepo.findAll();
	}

	public String updateEmployee(Employee id) {
		empRepo.save(id);
		return "Successfully Updated";
	}

	public List<Employee> getBetweenSalary(int salary1, int salary2) {
		return empRepo.getBetweenSalary(salary1, salary2);
	}

}
