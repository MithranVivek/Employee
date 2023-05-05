package com.example.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Employee")
public class EmployeeController {

	@Autowired
	EmployeeService empSer;

	@PostMapping(value = "/add")
	public String addEmployee(@RequestBody Employee emp) {
		return empSer.addEmployee(emp);
	}

	@GetMapping(value = "/get/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return empSer.getEmployee(id);
	}

	@DeleteMapping(value = "/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return empSer.deleteEmployee(id);
	}

	@PostMapping(value = "/addAll")
	public String addEmployee(@RequestBody List<Employee> emp) {
		return empSer.addEmployee(emp);
	}

	@GetMapping(value = "/getAll")
	public List<Employee> getEmployee() {
		return empSer.getEmployee();
	}

	@PutMapping(value = "/update/{id}")
	public String updateEmployee(@RequestBody Employee id) {
		return empSer.updateEmployee(id);
	}

	@GetMapping(value = "/getByGender/{gender}")
	public List<Employee> getByGender(@PathVariable String gender) {
		return empSer.getEmployee(gender);
	}

	@GetMapping(value = "/getByAge/{age}")
	public List<Employee> getByAge(@PathVariable int age) {
		return empSer.getByAge(age);
	}

	@GetMapping(value = "/getByAboveAge/{age}")
	public List<Employee> getByAboveAge(@PathVariable int age) {
		return empSer.getByAboveAge(age);
	}

	@GetMapping(value = "/getByBelowAge/{age}")
	public List<Employee> getByBelowAge(@PathVariable int age) {
		return empSer.getByBelowAge(age);
	}

	@GetMapping(value = "/getBySalary/{salary}")
	public List<Employee> getBySalary(@PathVariable int salary) {
		return empSer.getBySalary(salary);
	}

	@GetMapping(value = "/getByAboveSalary/{salary}")
	public List<Employee> getByAboveSalary(@PathVariable int salary) {
		return empSer.getByAboveSalary(salary);
	}

	@GetMapping(value = "/getByBelowSalary/{salary}")
	public List<Employee> getByBelowSalary(@PathVariable int salary) {
		return empSer.getByBelowSalary(salary);
	}

	@GetMapping(value = "/getMaxSalary")
	public String getMaxSalary() {
		return empSer.getMaxSalary();
	}

	@GetMapping(value = "/getMaxSalaryEmp")
	public List<Employee> getMaxSalaryEmp() {
		return empSer.getMaxSalaryEmp();
	}

	@GetMapping(value = "/getMinAgeEmp")
	public List<Employee> getMinAgeEmp() {
		return empSer.getMinAgeEmp();
	}

	@GetMapping(value = "/getNameByBetweenAge/{age1}/{age2}")
	public List<String> getNameByBetweenAge(@PathVariable int age1, @PathVariable int age2) {
		return empSer.getNameByBetweenAge(age1, age2);
	}

	@GetMapping(value = "/getIdByBetweenSalary/{salary1}/{salary2}")
	public List<Integer> getIdByBetweenSalary(@PathVariable int salary1, @PathVariable int salary2) {
		return empSer.getIdByBetweenSalary(salary1, salary2);
	}

	@GetMapping(value = "/getSameNameEmpId/{name}")
	public List<Integer> getSameNameEmpId(@PathVariable String name) {
		return empSer.getSameNameEmpId(name);
	}

	@GetMapping(value = "/getAboveAgeIncrement")
	public List<Employee> getAboveAgeIncrement() {
		return empSer.getAboveAgeIncrement();
	}

//---------------------------------------------------------------------------------
//	SQL Queries Practice
//---------------------------------------------------------------------------------

	@GetMapping(value = "/getBetweenSalary/{salary1}/{salary2}")
	public List<Employee> getBetweenSalary(@PathVariable int salary1, @PathVariable int salary2) {
		return empSer.getBetweenSalary(salary1, salary2);
	}

}
