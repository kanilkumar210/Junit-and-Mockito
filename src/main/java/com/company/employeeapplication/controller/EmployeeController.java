package com.company.employeeapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.employeeapplication.entity.Employee;
import com.company.employeeapplication.service.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		System.out.println("Controller...");
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/getEmployees")
	public List<Employee> getAllEmployees() {
		System.out.println("Controller...");
		return employeeService.getAllEmployees();
	}

	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable("id") long id) {
		System.out.println("Controller...");
		return employeeService.getEmployeeById(id);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployeeById(@PathVariable("id") long id) {
		return employeeService.deleteEmployee(id);
	}

}
