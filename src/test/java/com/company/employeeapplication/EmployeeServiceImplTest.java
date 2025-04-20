package com.company.employeeapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.employeeapplication.entity.Employee;
import com.company.employeeapplication.repository.EmployeeRepository;
import com.company.employeeapplication.serviceimpl.EmployeeServiceImpl;

@SpringBootTest
public class EmployeeServiceImplTest {

	@Mock
	EmployeeRepository employeeRepo;

	@InjectMocks
	EmployeeServiceImpl employeeServiceimpl;

	Employee employee = new Employee(1, "AK", 34, 78000);
	Employee employee1 = new Employee(2, "AK", 34, 78000);
	Employee employee2 = new Employee(2, "AK", 34, 78000);

	@Test
	public void saveEmployeeTest() {
		when(employeeRepo.save(employee)).thenReturn(employee);
		assertEquals(employee, employeeServiceimpl.saveEmployee(employee));
	}

	@Test
	public void getEmployeesTest() {
		List<Employee> empList = new ArrayList<>();
		empList.add(employee);
		empList.add(employee1);
		empList.add(employee2);
		when(employeeRepo.findAll()).thenReturn(empList);
		assertEquals(empList, employeeServiceimpl.getAllEmployees());
	}

//	@Test
//	public void getEmployeeByIdTest() {
//		Optional<Employee> employeeObj = Optional.ofNullable(new Employee(1, "AK", 34, 78000));
//
//		// long id=1;
//		when(employeeRepo.findById(employeeObj.get().getId())).thenReturn(employeeObj);
//		assertEquals(1, employeeServiceimpl.getEmployeeById(employeeObj.get().getId()).getId());
//	}

	@Test
	public void deleteEmployeeByIdTest() {
		String string = "Employee deleted successfully with id : " + employee.getId();

		assertEquals(string, employeeServiceimpl.deleteEmployee(employee.getId()));

	}

}
