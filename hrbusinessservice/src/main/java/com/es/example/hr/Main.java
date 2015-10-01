package com.es.example.hr;

import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.es.example.hr.model.Country;
import com.es.example.hr.model.Department;
import com.es.example.hr.model.Employee;
import com.es.example.hr.model.Job;
import com.es.example.hr.model.JobHistory;
import com.es.example.hr.model.Location;
import com.es.example.hr.model.Region;
import com.es.example.hr.service.EmployeeSearchService;
import com.es.example.hr.service.EmployeeService;

public class Main {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("hr-business-services.xml");
		
		EmployeeService empManager = (EmployeeService) ctx.getBean("employeeServiceImpl");
        EmployeeSearchService empSearch = (EmployeeSearchService) ctx.getBean("employeeSearchServiceImpl");
 
        
        
//		List<Employee> listEmp = empManager.findAllEmployees();
//		System.out.println("Employee count: " + listEmp.size());	
//		for(Employee e : listEmp){
//			
//			System.out.println(e.getJob().getId());
//			if(e.getDepartment() != null){
//				System.out.println(" Department Name: "+e.getDepartment().getName());
//			}
//			
//			Set<JobHistory> historys = e.getJobHistory();
//			for(JobHistory history : historys){
//				System.out.println("Job start date: "+history.getStartDate());
//			}
//		}
//
//		List<Job> listJobs = empManager.findAllJobs();
//		System.out.println("Jobs count: " + listJobs.size());	
//		
//		List<Department> listDep = empManager.findAllDepartments();
//		System.out.println("Department count: " + listDep.size());		
//		
//		for(Department dep : listDep){
//			
//			for(Employee emp : dep.getEmployees()){
//				System.out.println("Employee: "+emp.getFirstName()+" belongs to Department: "+dep.getName());
//			}
//		}
//		
//		//Regions
//		List<Region> listReg = empManager.findAllRegions();
//		System.out.println("Region count: " + listReg.size());		
//				
//		//Countries
//		List<Country> listCountries = empSearch.findAllCountries();
//		System.out.println("Country count: " + listCountries.size());
//       for(Country e : listCountries){
//			
//			System.out.println(e.getCountryName());
//       }
//		
//		
//		//Locations
//		List<Location> listLocations = empManager.findAllLocations();
//		System.out.println("Locations count: " + listLocations.size());		
//		
//		//Job History
//		List<JobHistory> listHistory = empManager.findAllJobHistory();
//		System.out.println("JobHistory count: " + listHistory.size());		
//		
//		List<Employee> searchJob = empManager.searchEmployee1("United Kingdom", "s","khan");
//		for (Employee sj : searchJob) 
//			
//				{
//			
//                       if(sj.getFirstName()== null){
//                    	   System.out.println("No such Value");
//                       }
//			
//			
//			System.out.println(sj.getDepartment().getLocation().getCountry().getCountryName());
//		}
		
	}
}
