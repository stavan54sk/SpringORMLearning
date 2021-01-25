package com.testpackage.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.testpackage.dto.Employee;


public class TestClient {
	
	public static void main(String[] args) {
		Configuration configuration=new Configuration();
		configuration.configure("com\\testpackage\\configuration\\hibernate.cfg.xml");
		
		
		Session session=configuration.buildSessionFactory().openSession();
		
		Transaction transaction =session.getTransaction();
		transaction.begin();
		Employee employee=new Employee();
		employee.setEfirstName("FIRSTANME");
		employee.setElastName("LASTNAME");
		employee.setEid(54);
		employee.setEsalary(6000);
		System.out.println("###############################CREATE####################################");
		session.saveOrUpdate(employee);
		System.out.println("###############################GET####################################");
		Employee employee1=		(Employee) session.get("com.testpackage.dto.Employee", 54);
		System.out.println(employee1.getEfirstName());
		System.out.println(employee1.getElastName());
		System.out.println(employee1.getEid());
		System.out.println(employee1.getEsalary());
		System.out.println("###############################DELETE####################################");
		session.delete(employee);		
		transaction.commit();
		session.close();

}
}