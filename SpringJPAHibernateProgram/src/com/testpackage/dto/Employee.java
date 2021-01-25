package com.testpackage.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.osgi.service.component.annotations.Component;
import lombok.Data;


@Entity
@Table(name = "EMPLOYEE")
@Data
@Component
public class Employee {
	@Id
	@Column(name="ID")
	private int eid;
	
	@Column(name="FIRSTNAME")
	private String efirstName;
	
	@Column(name="LASTNAME")
	private String elastName;
	
	@Column(name="SALARY")
	private int esalary;

}
