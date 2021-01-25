package com.testpackage.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.testpackage.dto.Employee;


public class EmployeeDaoImpl implements EmployeeDao {
	
	HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	@Override
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(employee);
	}

	@Transactional
	@Override
	public void updatesEmployee(Employee employee) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(employee);
	}

	@Transactional
	@Override
	public void getEmployee(Employee employee) {
		// TODO Auto-generated method stub
		hibernateTemplate.get("com.testpackage.dto.Employee", employee.getEid());
	}

	@Transactional
	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(employee);

	}

}
