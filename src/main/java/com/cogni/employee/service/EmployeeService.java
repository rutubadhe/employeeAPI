package com.cogni.employee.service;

import java.util.List;

import com.cogni.employee.entity.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee employee);

	List<Employee> listEmployee();

	Employee fetchEmployeeById(Long id);

	String deleteEmployee(Long id);

	Employee editEmployee(Long id, Employee employee);

}
