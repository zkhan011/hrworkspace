package com.es.example.hr.dao;

import java.io.IOException;
import java.util.List;






import com.es.example.hr.model.Country;
import com.es.example.hr.model.Department;
import com.es.example.hr.model.Employee;
import com.es.example.hr.model.Job;
import com.es.example.hr.model.JobHistory;
import com.es.example.hr.model.Location;
import com.es.example.hr.model.Region;

public interface EmployeeDAO {
	
	

	void insertEmployee(Employee user);
	
	List<Employee> findOneEmployee(int id);
    void findOneEmployee1(int id);
	List<Employee> findAllEmployees();
	
	List<Job> findAllJobs();	
	
	List<Department> findAllDepartments();
	
	List<Region> findAllRegions();
	
	List<Country> findAllCountries();
	
	List<Location> findAllLocations();
	
	List<JobHistory> findAllJobHistory();

	void updateEmployee(Employee employee);

	void deleteEmployee(Employee employee);
	
	List<Employee> searchEmployee();
	public List<Employee> searchEmployee1(String countryName, String firstName, String lastName,int setFirstResult , int setLastResult);

	List<Job> findOneJ(String id);

	List<Department> findOneD(String id);
	
	
}
