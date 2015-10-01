package com.es.example.hr.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="EMPLOYEES")
public class Employee {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	
	@SequenceGenerator(name="Emp_Gen", sequenceName="EMPLOYEES_SEQ")
	@Id @GeneratedValue(generator="Emp_Gen")		
	@Column(name="EMPLOYEE_ID", nullable = false)
	private int id;	
	
	@Column(name="FIRST_NAME", nullable = false, updatable=true )
	private String firstName;
	
	@Column(name="LAST_NAME", nullable = false, updatable = true)
	private String lastName;
	
	@Column(name="PHONE_NUMBER", nullable = false, updatable = true)
	private String phoneNumber;
	
	
	@NotEmpty (message="may not be empty")
	@Column(name="EMAIL", nullable = false , updatable = true)
	private String email;	
	
	@Column(name="HIRE_DATE", nullable = false)
	private Date hireDate;		
	
	@Column(name="SALARY", nullable = false)
	private int salary;		
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@OneToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name="JOB_ID", nullable=false)
	private Job job;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name="DEPARTMENT_ID")
	private Department department;
	
	@OneToMany(mappedBy="employee", fetch = FetchType.EAGER)
	private Set<JobHistory> jobHistory;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<JobHistory> getJobHistory() {
		return jobHistory;
	}

	public void setJobHistory(Set<JobHistory> jobHistory) {
		this.jobHistory = jobHistory;
	}	
	
	//@ManyToOne(optional = false, fetch = FetchType.EAGER)
	//@JoinColumn(name="MANAGER_ID", nullable=false)	
	//private Employee manager;
	

	
}
