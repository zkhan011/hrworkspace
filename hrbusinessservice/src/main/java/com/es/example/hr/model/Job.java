package com.es.example.hr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="JOBS")
public class Job {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="JOB_ID", nullable = false)
	private String id;	
	
	@Column(name="JOB_TITLE", nullable = false)
	private String title;
	
	@Column(name="MIN_SALARY", nullable = false)
	private String minSalary;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}
	
	
}
