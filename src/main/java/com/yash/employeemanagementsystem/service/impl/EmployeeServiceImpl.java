package com.yash.employeemanagementsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.employeemanagementsystem.entity.Employee;
import com.yash.employeemanagementsystem.exception.EmployeeNotFoundException;
import com.yash.employeemanagementsystem.repository.EmployeeRepository;
import com.yash.employeemanagementsystem.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeById(Long id) {
		
		return employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee  not found with id"+id));
	}

	@Override
	public void deleteEmployeeById(Long id) {
		
		Employee employee= employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee  not found with id"+id));
		employeeRepository.delete(employee);
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee employeeObj= employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee  not found with id"+id));
		employeeObj.setFirstName(employee.getFirstName());
		employeeObj.setLastName(employee.getLastName());
		employeeObj.setDesignation(employee.getDesignation());
		employeeObj.setDateOfJoining(employee.getDateOfJoining());
		employeeObj.setReportingManager(employee.getReportingManager());
		employeeObj.setTotalExperience(employee.getTotalExperience());
		employeeObj.setSkills(employee.getSkills());
		
		
		return employeeRepository.save(employeeObj);
	}

}
