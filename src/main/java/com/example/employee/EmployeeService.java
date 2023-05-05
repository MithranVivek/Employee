package com.example.employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao empDao;

	public String addEmployee(Employee emp) {
		return empDao.addEmployee(emp);
	}

	public Employee getEmployee(int id) {
		return empDao.getEmployee(id);
	}

	public String deleteEmployee(int id) {
		return empDao.deleteEmployee(id);
	}

	public String addEmployee(List<Employee> emp) {
		return empDao.addEmployee(emp);
	}

	public List<Employee> getEmployee() {
		return empDao.getEmployee();
	}

	public String updateEmployee(Employee id) {
		return empDao.updateEmployee(id);
	}

	public List<Employee> getEmployee(String gender) {
		List<Employee> allEmp = empDao.getEmployee();
		List<Employee> empByGender = allEmp.stream().filter(x -> x.getGender().equalsIgnoreCase(gender))
				.collect(Collectors.toList());
		return empByGender;
	}

	public List<Employee> getByAge(int age) {
		List<Employee> getByAge = empDao.getEmployee().stream().filter(x -> x.getAge() == age)
				.collect(Collectors.toList());
		return getByAge;
	}

	public List<Employee> getByAboveAge(int age) {
		return empDao.getEmployee().stream().filter(x -> x.getAge() > age).collect(Collectors.toList());
	}

	public List<Employee> getByBelowAge(int age) {
		return empDao.getEmployee().stream().filter(x -> x.getAge() < age).collect(Collectors.toList());
	}

	public List<Employee> getBySalary(int salary) {
		return empDao.getEmployee().stream().filter(x -> x.getSalary() == salary).collect(Collectors.toList());
	}

	public List<Employee> getByAboveSalary(int salary) {
		return empDao.getEmployee().stream().filter(x -> x.getSalary() > salary).collect(Collectors.toList());
	}

	public List<Employee> getByBelowSalary(int salary) {
		return empDao.getEmployee().stream().filter(x -> x.getSalary() < salary).collect(Collectors.toList());
	}

	public String getMaxSalary() {
		return "Maximum Salary in Employee List = "
				+ empDao.getEmployee().stream().max(Comparator.comparing(Employee::getSalary)).get().getSalary();
	}

	public List<Employee> getMaxSalaryEmp() {
		int maxSalary = empDao.getEmployee().stream().max(Comparator.comparing(Employee::getSalary)).get().getSalary();
		return empDao.getEmployee().stream().filter(x -> x.getSalary() == maxSalary).collect(Collectors.toList());
	}

	public List<Employee> getMinAgeEmp() {
		int minAge = empDao.getEmployee().stream().min(Comparator.comparing(Employee::getAge)).get().getAge();
		return empDao.getEmployee().stream().filter(x -> x.getAge() == minAge).collect(Collectors.toList());
	}

	public List<String> getNameByBetweenAge(int age1, int age2) {

		return empDao.getEmployee().stream().filter(x -> x.getAge() >= age1 && x.getAge() <= age2).map(y -> y.getName())
				.collect(Collectors.toList());
	}

	public List<Integer> getIdByBetweenSalary(int salary1, int salary2) {
		return empDao.getEmployee().stream().filter(x -> x.getSalary() >= salary1 && x.getSalary() <= salary2)
				.map(y -> y.getId()).collect(Collectors.toList());
	}

	public List<Integer> getSameNameEmpId(String name) {

		return empDao.getEmployee().stream().filter(x -> x.getName().toLowerCase().contains(name)).map(y -> y.getId())
				.collect(Collectors.toList());
	}

	public List<Employee> getAboveAgeIncrement() {
		List<Employee> allEmp = empDao.getEmployee();
//		List<Employee> incList = new ArrayList<>();
//		for (Employee x : allEmp) {
//			if (x.getAge() > 25) {
//				int inc = x.getSalary() + (x.getSalary() * 5 / 100);
//				x.setSalary(inc);
//				incList.add(x);
//			} else {
//				incList.add(x);
//			}
//		}
//		return incList;

		for (Employee e : allEmp) {
			if (e.getAge() > 25) {
				e.setSalary(e.getSalary() + e.getSalary() * 5 / 100);
			}
		}
		return allEmp;
	}

//---------------------------------------------------------------------------------
//	SQL Queries Practice
//---------------------------------------------------------------------------------

	public List<Employee> getBetweenSalary(int salary1, int salary2) {
		return empDao.getBetweenSalary(salary1, salary2);
	}

}
