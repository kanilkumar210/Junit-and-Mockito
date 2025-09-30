package com.company.employeeapplication.controller;

import java.util.List;

import com.company.employeeapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import com.company.employeeapplication.entity.Employee;
import com.company.employeeapplication.service.IEmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;
//
//    @PostMapping("/save")
//    public Employee saveEmployee(@RequestBody Employee employee) {
//        System.out.println("Controller...");
//        return employeeService.saveEmployee(employee);
//    }

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

    @GetMapping("/getNamesBySalary")
    public List<String> getNamesBySalary(@RequestParam("salary") long salary) {
        return employeeService.getNamesBySalary(salary);
    }
}
