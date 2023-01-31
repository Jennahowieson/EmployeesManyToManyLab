package com.codeclan.example.employees;

import com.codeclan.example.employees.models.Department;
import com.codeclan.example.employees.models.Employee;
import com.codeclan.example.employees.models.Project;
import com.codeclan.example.employees.repositories.DepartmentRepository;
import com.codeclan.example.employees.repositories.EmployeeRepository;
import com.codeclan.example.employees.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class StarterTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void createEmployeesDepartmentAndProject(){
		Department engineering = new Department("engineering");
		departmentRepository.save(engineering);

		Employee eva = new Employee("Eva", "Long", 9087,engineering);
		employeeRepository.save(eva);
		Employee john = new Employee("John", "Smith", 9387,engineering);
		employeeRepository.save(john);
	}
	@Test
	public void addEmployeeAndProject() {

		Department finance = new Department("finance");
		departmentRepository.save(finance);

		Employee lewis = new Employee("Lewis", "Burn", 2342,finance);
		employeeRepository.save(lewis);

		Project codeclan = new Project("CodeClan", 80);
		projectRepository.save(codeclan);

		codeclan.addEmployee(lewis);
		projectRepository.save(codeclan);
	}
}
