package com.es.example.hr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class JobHistoryPK implements Serializable {
	
	@Column(name="EMPLOYEE_ID", nullable = false)
	private int employeeId;
	
	@Column(name="JOB_ID", nullable = false)
	private String jobId;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		result = prime * result + jobId.hashCode();
		return result;
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobHistoryPK other = (JobHistoryPK) obj;
		if (employeeId != other.getEmployeeId()) {
			return false;
		} else if (!jobId.equals(other.jobId))
			return false;
		
		return true;
	}
 	

}
