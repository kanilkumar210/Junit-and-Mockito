package com.company.employeeapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.company.employeeapplication.entity.Employee;
import com.company.employeeapplication.repository.EmployeeRepository;
import com.company.employeeapplication.service.IEmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class EmployeeRestControllerTest {

	@MockBean
	IEmployeeService employeeService;

	@MockBean
	EmployeeRepository employeeRepository;

	@Autowired
	private MockMvc mockMvc;

	private static ObjectMapper mapper = new ObjectMapper();

	Employee employee = new Employee(1, "AK", 34, 78000);
	Employee employee1 = new Employee(2, "AK", 34, 78000);
	Employee employee2 = new Employee(2, "AK", 34, 78000);

	@Test
	public void testSaveEmployee() throws Exception {
		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
		Mockito.when(employeeService.saveEmployee(ArgumentMatchers.any())).thenReturn(employee);
		String json = mapper.writeValueAsString(employee);
		MvcResult requestResult = mockMvc.perform(post("/save").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andReturn();
		String result = requestResult.getResponse().getContentAsString();

		Employee emp = new ObjectMapper().readValue(result, Employee.class);

		assertEquals(1, emp.getId());
	}

	@Test
	public void testGetEmployees() throws Exception {
		List<Employee> empList = new ArrayList<>();
		empList.add(employee);
		empList.add(employee1);
		empList.add(employee2);
		Mockito.when(employeeRepository.findAll()).thenReturn(empList);
		Mockito.when(employeeService.getAllEmployees()).thenReturn(empList);

		MvcResult requestResult = mockMvc.perform(get("/getEmployees")).andReturn();
		String result = requestResult.getResponse().getContentAsString();

		Employee[] emp = new ObjectMapper().readValue(result, Employee[].class);

		assertEquals(1, emp[0].getId());

	}

	@Test
	public void testGetEmployeeById() throws Exception {
		// Mockito.when(employeeRepository.findById(1L).get()).thenReturn(employee);
		Mockito.when(employeeService.getEmployeeById(employee.getId())).thenReturn(employee);
		MvcResult requestResult = mockMvc.perform(get("/getEmployeeById/" + employee.getId())).andReturn();
		String result = requestResult.getResponse().getContentAsString();

		Employee emp = new ObjectMapper().readValue(result, Employee.class);

		assertEquals(1, emp.getId());
	}

	@Test
	public void testDeleteEmployeeById() throws Exception {
		String string = "Employee deleted successfully with id : " + employee.getId();
		Mockito.when(employeeService.deleteEmployee(employee.getId())).thenReturn(string);

		MvcResult requestResult = mockMvc.perform(delete("/deleteEmployee/" + employee.getId())).andReturn();

		assertEquals(string, requestResult.getResponse().getContentAsString());

	}

}
