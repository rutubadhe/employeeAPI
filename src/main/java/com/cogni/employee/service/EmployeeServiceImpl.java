package com.cogni.employee.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogni.employee.entity.Employee;
import com.cogni.employee.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> listEmployee() {
		return employeeRepository.findAll();
	}


	@Override
	public Employee fetchEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}


	@Override
	public String deleteEmployee(Long id) {

		employeeRepository.deleteById(id);
		return "Employee record deleted";
	}


	@Override
	public Employee editEmployee(Long id, Employee employee) {
		
		Employee e=employeeRepository.findById(id).get();
		
		if(Objects.nonNull(employee.getEmployeeFirstName()) && !"".equals(employee.getEmployeeFirstName()))
		{
			e.setEmployeeFirstName(employee.getEmployeeFirstName());
		}
		//1
		
		if(Objects.nonNull(employee.getEmployeeLastName()) && !"".equals(employee.getEmployeeLastName()))
		{
			e.setEmployeeLastName(employee.getEmployeeLastName());
		}
		//2
		if(Objects.nonNull(employee.getEmployeeEmail()) && !"".equals(employee.getEmployeeEmail()))
		{
			e.setEmployeeEmail(employee.getEmployeeEmail());
		}
		//3
		if(Objects.nonNull(employee.getEmployeePhone()) && !"".equals(employee.getEmployeePhone()))
		{
			e.setEmployeePhone(employee.getEmployeePhone());
		}
		//4
		
		if(Objects.nonNull(employee.getEmployeeLocation()) && !"".equals(employee.getEmployeeLocation()))
		{
			e.setEmployeeLocation(employee.getEmployeeLocation());
		}//5
		
		
		return employeeRepository.save(e);
		
	}

	
	
}
