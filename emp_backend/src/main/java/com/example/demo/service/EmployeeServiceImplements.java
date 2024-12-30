package com.example.demo.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeServiceImplements implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee addEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		try {
			BeanUtils.copyProperties(employeeDto, employee);
			employeeRepository.save(employee);
			return employee;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return employee;
	}

	@Override
	public Employee updateEmployee(Long id, EmployeeDto employeeDetails) {
		Employee employee = new Employee();
		try {
			employee = employeeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + "does not exists"));
			employee = Employee.builder().id(id).fname(employeeDetails.getFname()).lname(employeeDetails.getLname())
					.email(employeeDetails.getEmail()).salary(employeeDetails.getSalary())
					.department(employeeDetails.getDepartment()).designation(employeeDetails.getDesignation())
					.joiningDate(employeeDetails.getJoiningDate()).build();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return employee;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + "does not exists"));
	}

	@Override
	public Employee deleteEmployee(Long id) {	
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + "does not exists"));

		employeeRepository.delete(employee);
		return employee;
	}

}
