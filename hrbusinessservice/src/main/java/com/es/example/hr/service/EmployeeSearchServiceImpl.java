package com.es.example.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.example.hr.dao.EmployeeDAO;
import com.es.example.hr.model.Country;
import com.es.example.hr.model.Employee;
import com.es.example.hr.model.Location;

@Service
public class EmployeeSearchServiceImpl implements EmployeeSearchService {
	@Autowired
	private EmployeeDAO empDAO;
    @Transactional  
	public List<Employee> searchEmployee() {
		
		return empDAO.searchEmployee();
	}
	public List<Country> findAllCountries() {
		
		return empDAO.findAllCountries();
	}
	public List<Employee> searchEmployee1(String countryName, String firstName,
			String lastName, int setFirstResult , int setLastResult) {
		
		return empDAO.searchEmployee1(countryName, firstName, lastName,setFirstResult , setLastResult);
	}
	public List<Location> findAllLocations() {
		
		return empDAO.findAllLocations();
	}
	

	
	
}
