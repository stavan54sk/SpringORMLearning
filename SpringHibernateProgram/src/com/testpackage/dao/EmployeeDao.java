package com.testpackage.dao;


import org.springframework.stereotype.Repository;

import com.testpackage.dto.Employee;
@Repository
public interface EmployeeDao {
	
	public void createEmployee(Employee employee);
	
	public void updatesEmployee(Employee employee);
	
	public void getEmployee(Employee employee);
	
	public void deleteEmployee(Employee employee);

}
