package com.testpackage.configuration;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.testpackage.dao.EmployeeDao;
import com.testpackage.dao.EmployeeDaoImpl;

@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages={"com.testpackage.dto","com.testpackage.dao"})
public class ConfigurationClass {
	
	@Bean
	public LocalEntityManagerFactoryBean  localEntityManagerFactoryBean()
	{
		LocalEntityManagerFactoryBean  localEntityManagerFactoryBean =new LocalEntityManagerFactoryBean ();
		localEntityManagerFactoryBean .setPersistenceUnitName("employeedb");
		return localEntityManagerFactoryBean;
		
	}
	
	@Bean
	public JpaTransactionManager jpaTransactionManager()
	{
		JpaTransactionManager jpaTransactionManager=new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(localEntityManagerFactoryBean().getObject());
		return jpaTransactionManager;
	}
	
	@Bean
	public EmployeeDao employeeDao()
	{
		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		return employeeDaoImpl;
	}
}
