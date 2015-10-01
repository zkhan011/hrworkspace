package com.es.example.hr.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.example.hr.dao.EmployeeDAO;
import com.es.example.hr.dto.CreateEmployeeBean;
import com.es.example.hr.model.Country;
import com.es.example.hr.model.Department;
import com.es.example.hr.model.Employee;
import com.es.example.hr.model.Job;
import com.es.example.hr.model.JobHistory;
import com.es.example.hr.model.Location;
import com.es.example.hr.model.Region;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO empDAO;

	@Transactional
	public void insertEmployee(CreateEmployeeBean employee) throws InvalidSalaryException {
		
		if(employee.getSalary() > 200000){
			throw new InvalidSalaryException("Salary cannot be higher than 200000");
		}
		//Step
		Employee emp = new Employee();
		
		// int d1 = (employee.getDepartment().getId());
		//  Job j = (employee.getJob());
	     // Department d = (employee.getDepartment());
		//d1.setName(employee.getDepartment().getName());
		 
		 //int d1 =Integer.parseInt(employee.getDepartment().getId());
//		  List<Job> jobs = findAllJobs();
//		 // Job j = new Job()  ;
//		  int j1 = jobs.indexOf(employee.getJob().getId());
//		  Job j = jobs.get(j1);
//		  List<Department> departments = findAllDepartments();
//		  int d1 = jobs.indexOf(employee.getDepartment().getId());
//		  Department d = departments.get(d1);
		   
		 // j.setId(j1);
		  
		  //Department d = new Department();
		  //d.setId(d1);
		//j1.setTitle(employee.getJob().getTitle());
	//	emp.Job j1 = employee.getJob().getId();
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		emp.setPhoneNumber(employee.getPhoneNumber());
		//emp.setHireDate(employee.getHireDate());
		emp.setSalary(employee.getSalary());
	   // emp.setJob(j);
	    //emp.setDepartment(d);
	    //emp.setDepartment(d);
		List<Job> jobs = findOneJ(employee.getJob());
		Job j1 = jobs.get(0);		
		emp.setJob(j1);
		List<Department> departments= findOneD(employee.getDepartment());
		Department d1 = departments.get(0);
		emp.setDepartment(d1);
		emp.setHireDate(new Date());
		
		empDAO.insertEmployee(emp);
		
	}

	public List<Employee> findAllEmployees() {
		return empDAO.findAllEmployees();		
	}
	
	public List<Job> findAllJobs() {
		return empDAO.findAllJobs();		
	}	
	
	public List<Department> findAllDepartments() {
		return empDAO.findAllDepartments();		
	}	
	
	public List<Region> findAllRegions() {
		return empDAO.findAllRegions();
	}
	
	//public List<Country> findAllCountries() {
		//return empDAO.findAllCountries();
	//}	
	
	public List<Location> findAllLocations() {
		return empDAO.findAllLocations();
	}	
	
	public List<JobHistory> findAllJobHistory(){
		return empDAO.findAllJobHistory();
	}

	public void findOneEmployee1(int id) {
		empDAO.findOneEmployee(id);
		
	}

	public List <Employee> findOneEmployee(int id) {
		
		return empDAO.findOneEmployee(id);
	}
    @Transactional
	public void updateEmployee(Employee employee) {
		  
			empDAO.updateEmployee(employee);
		
	}

	public void deleteEmployee(Employee employee) {
		    
		empDAO.deleteEmployee(employee);
		
	}
	public List<Employee>searchEmployee1(String jobType, String firstName, String lastName,int setFirstResult ,int setLastResult){
		return empDAO.searchEmployee1(jobType, firstName, lastName,setFirstResult ,setLastResult);
	}

	public List<Job> findOneJ(String id) {
		
		return empDAO.findOneJ(id);
	}

	public List<Department> findOneD(String id) {
		
		return empDAO.findOneD(id);
	}

}
