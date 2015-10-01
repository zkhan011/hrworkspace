package com.es.example.hr.service;

import java.util.List;

import com.es.example.hr.model.Employee;
import com.es.example.hr.model.Country;
import com.es.example.hr.model.Department;
import com.es.example.hr.model.Employee;
import com.es.example.hr.model.Job;
import com.es.example.hr.model.JobHistory;
import com.es.example.hr.model.Location;
import com.es.example.hr.model.Region;

public interface EmployeeSearchService{
	
	List<Employee> searchEmployee();
	List<Country> findAllCountries();
	List <Employee>searchEmployee1(String countryName, String firstName, String lastName,int setFirstResult , int setLastResult);
	List<Location> findAllLocations();
	

}
