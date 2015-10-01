package com.es.example.hr.service;

import java.util.List;

import com.es.example.hr.dto.CreateEmployeeBean;
import com.es.example.hr.model.Country;
import com.es.example.hr.model.Department;
import com.es.example.hr.model.Employee;
import com.es.example.hr.model.Job;
import com.es.example.hr.model.JobHistory;
import com.es.example.hr.model.Location;
import com.es.example.hr.model.Region;

public interface EmployeeService {

	void insertEmployee(CreateEmployeeBean emp)  throws InvalidSalaryException ;
    List<Employee> findOneEmployee(int id);
    void findOneEmployee1(int id);
	List<Employee> findAllEmployees();	
	
	List<Job> findAllJobs();
	List<Job> findOneJ(String id);
	List<Department> findOneD(String id);
	List<Department> findAllDepartments();
	
	List<Region> findAllRegions();
	
	//List<Country> findAllCountries();
	
	List<Location> findAllLocations();
	
	List<JobHistory> findAllJobHistory();
	void updateEmployee(Employee employee);
	void deleteEmployee(Employee employee);
	List <Employee>searchEmployee1(String jobType, String firstName, String lastName,int setFirstResult , int setLastResult);
	
}
