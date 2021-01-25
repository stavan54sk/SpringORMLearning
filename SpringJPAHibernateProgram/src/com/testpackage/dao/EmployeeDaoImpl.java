package com.testpackage.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.testpackage.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	@PersistenceContext(unitName="employeedb")
	 private EntityManager entityManager;
	
	@Transactional
	@Override
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.persist(employee);
	}

	@Transactional
	@Override
	public void updatesEmployee(Employee employee) {
		// TODO Auto-generated method stub
	}

	@Transactional
	@Override
	public void getEmployee(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.find(Employee.class, employee.getEid());
	}

	@Transactional
	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.remove(employee);

	}

}
