package com.es.example.hr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="JOB_HISTORY")
public class JobHistory {

	@EmbeddedId
	private JobHistoryPK id;
	
	@Column(name="START_DATE", nullable = false)
	private Date startDate;
	
	@Column(name="END_DATE", nullable = false)
	private Date endDate;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name="DEPARTMENT_ID")
	private Department department;
	
    @ManyToOne
    @NotFound(action=NotFoundAction.IGNORE)
    @JoinColumn(name="EMPLOYEE_ID", insertable=false, updatable=false, nullable=true)
    private Employee employee;	

	public JobHistoryPK getId() {
		return id;
	}

	public void setId(JobHistoryPK id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}	
	
	
}
