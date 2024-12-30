package com.example.demo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class EmployeeDto {

	
	private long id;
	
	private String fname;
	
	private String lname;
	
	private String email;
	
	private long salary;
	
	private String department;
	
	private String designation;
	
	private LocalDate joiningDate;
}
