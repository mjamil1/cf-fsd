package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;

import junit.framework.Assert;

@SpringBootTest
class MainTest {

	@Mock
	private EmployeeRepository empRepo;
	
	@Autowired
	private EmployeeService empService;
	
	@Before(value = "")
	public void setUp() {
		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testEmployee() {
		
		Employee mockEmployee = new Employee(19232, "Joe","Jackson","mjamil@loyola.edu","Engineer","FINAN","OM1","A Boss","211-242-1542","01/01/2012","02/23/1990");
		
		
		Assert.assertEquals(19232, mockEmployee.getId());
		Assert.assertEquals("Joe", mockEmployee.getFirstName());
		Assert.assertEquals("Jackson", mockEmployee.getLastName());
		Assert.assertEquals("mjamil@loyola.edu", mockEmployee.getEmail());
		Assert.assertEquals("Engineer", mockEmployee.getJobTitle());
		Assert.assertEquals("OM1", mockEmployee.getLocation());
		Assert.assertEquals("FINAN", mockEmployee.getDepartment());
		Assert.assertEquals("A Boss", mockEmployee.getReportingManager());
		Assert.assertEquals("211-242-1542", mockEmployee.getPhoneNumber());
		Assert.assertEquals("01/01/2012", mockEmployee.getStartDate());
		Assert.assertEquals("02/23/1990", mockEmployee.getBirthDate());
		
		Employee mockEmployee2 = mockEmployee; 
	 
	}
	
	@Test
	public void testAddEmployee() {
		
		Employee mockEmployeeThree = new Employee(122, "Alex","Menner","amenn@carefirst.com","Analyst","IT","OM1","Bigger Boss","411-222-9895","01/01/2018","02/23/1994");
		Employee mockEmployee = new Employee(15, "Jeremy","Jackson","jjack1@umd.edu","Engineer","IT","OM2","A Boss","211-242-1584","01/01/2012","02/23/1990");

		empService.saveEmployee(mockEmployee);
		
		Employee mockEmployeeTwo = empService.getEmployeeById(15); 
		
		Assert.assertEquals(mockEmployee.getId(), mockEmployeeTwo.getId()); 
		
	}
	
	@Test
	public void testGetEmployee() {
		
		List<Employee> employeeList = empService.getAllEmployees();
		
		System.out.println(employeeList); 
		
		
	}
	
	@Test
	public void testForms() {
		
	}
	
	
	
	
}
