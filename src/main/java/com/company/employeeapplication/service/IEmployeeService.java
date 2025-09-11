package com.company.employeeapplication.service;

import java.util.List;

import com.company.employeeapplication.entity.Employee;

public interface IEmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(long id);

	String deleteEmployee(long id);

    List<String> getNamesBySalary(long salary);
}
