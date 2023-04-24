package com.yash.employeemanagementsystem.service;

import java.util.List;

import com.yash.employeemanagementsystem.entity.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee );
	public List<Employee> getAllEmployee();
	public Employee findEmployeeById(Long id);
	public void deleteEmployeeById(Long id);
	public Employee updateEmployee(Long id,Employee employee);
	

}
