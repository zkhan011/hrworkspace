package com.es.example.hr.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="DEPARTMENTS")
public class Department {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="DEPARTMENT_ID", nullable = false)
	private int id;	
	
	
	
	@Column(name="DEPARTMENT_NAME", nullable = false)
	private String name;
	
	@OneToMany(mappedBy="department", fetch = FetchType.EAGER)
	private Set<Employee> employees;
	
	@OneToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name="LOCATION_ID", nullable=false)	
	private Location location;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
