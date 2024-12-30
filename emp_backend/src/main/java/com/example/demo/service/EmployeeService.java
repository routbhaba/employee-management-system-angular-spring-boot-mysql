package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.Employee;

public interface EmployeeService {

	List<Employee> findAllEmployee();

	Employee addEmployee(EmployeeDto employee);

	Employee updateEmployee(Long id, EmployeeDto employeeDetails);

	Employee getEmployeeById(Long id);

	Employee deleteEmployee(Long id);


}
