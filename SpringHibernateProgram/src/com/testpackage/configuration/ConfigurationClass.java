package com.testpackage.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.testpackage.dao.EmployeeDao;
import com.testpackage.dao.EmployeeDaoImpl;
import com.testpackage.dto.Employee;
@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages={"com.testpackage.dto","com.testpackage.dao"})
@PropertySource("classpath:com/testpackage/configuration/application.properties")
public class ConfigurationClass {
	
	
	@Autowired
	private Environment environment;
	
	@Bean
	public DriverManagerDataSource driverManagerDataSource()
	{
		
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/classicmodels");
		driverManagerDataSource.setUsername("sa");
		driverManagerDataSource.setPassword("Test@123");
		return driverManagerDataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean()
	{	Properties  hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate.dialect",environment.getProperty("dialect") );
		hibernateProperties.setProperty("hibernate.show_sq", environment.getProperty("showsql"));
		LocalSessionFactoryBean localSessionFactoryBean=new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(driverManagerDataSource());
		localSessionFactoryBean.setAnnotatedClasses(Employee.class);
		localSessionFactoryBean.setHibernateProperties(hibernateProperties);
		return localSessionFactoryBean;
	}

	@Bean
	public HibernateTransactionManager hibernateTransactionManager()
	{
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(localSessionFactoryBean().getObject());
		return hibernateTransactionManager;
	}
	
	@Bean
	public HibernateTemplate hibernateTemplate()
	{
		HibernateTemplate hibernateTemplate=new HibernateTemplate();
		hibernateTemplate.setSessionFactory(localSessionFactoryBean().getObject());
		return hibernateTemplate;
	}
	
	@Bean
	public EmployeeDao employeeDao()
	{
		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		employeeDaoImpl.setHibernateTemplate(hibernateTemplate());
		return employeeDaoImpl;
	}
}
