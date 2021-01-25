package com.testpackage.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.testpackage.configuration.ConfigurationClass;
import com.testpackage.dao.EmployeeDao;
import com.testpackage.dao.EmployeeDaoImpl;
import com.testpackage.dto.Employee;

public class TestClient {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(ConfigurationClass.class);
		EmployeeDao employeeDao=applicationContext.getBean(EmployeeDao.class);
		Employee employee=new Employee();
		employee.setEid(78);
		employee.setEfirstName("1STFIRST");
		employee.setElastName("LSTNAME");
		employee.setEsalary(25000);
		
		employeeDao.createEmployee(employee);
	}

}
