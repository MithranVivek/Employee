package com.example.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select * from employee WHERE salary>=? AND salary<=?", nativeQuery = true)
	public List<Employee> getBetweenSalary(int salary1, int salary2);

}
