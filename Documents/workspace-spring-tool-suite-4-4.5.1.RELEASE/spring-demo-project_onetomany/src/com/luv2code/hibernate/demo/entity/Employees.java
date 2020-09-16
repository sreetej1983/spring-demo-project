package com.luv2code.hibernate.demo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEES")
public class Employees {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="EMP_ID", unique = true, nullable = false)
    private Long empId;
 
	private String name;
	 
    private String department;
 
    private Long salary;
 
    @Column(name="JOINED_ON")
    private String joinedOn;
    
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
    private EmpDetails empDetails;
    
    
    public Employees() {}
	public Employees(String name, String department, Long salary, String string) {
		//super();
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.joinedOn = string;
		//this.empDetails = empDetails;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getJoinedOn() {
		return joinedOn;
	}

	public void setJoinedOn(String joinedOn) {
		this.joinedOn = joinedOn;
	}

	public EmpDetails getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(EmpDetails empDetails) {
		this.empDetails = empDetails;
	}

    
}
