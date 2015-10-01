package com.es.train.hr.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.es.example.hr.dto.CreateEmployeeBean;
import com.es.example.hr.model.Department;
import com.es.example.hr.model.Employee;
import com.es.example.hr.model.Job;
import com.es.example.hr.service.EmployeeService;
import com.es.example.hr.service.InvalidSalaryException;


@Controller
@RequestMapping(value="/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping(value={"/list"}, method=RequestMethod.GET)
	public ModelAndView getAllEmployees(){
		ModelAndView mav = new ModelAndView("employees");
		List<Employee> employees = empService.findAllEmployees();
		mav.addObject("empList", employees);
		return mav;
	}
	
	@RequestMapping(value={"/create"}, method=RequestMethod.GET)
	public ModelAndView newShopPage() {
		List<Department> department = empService.findAllDepartments();
        List<Job> job = empService.findAllJobs();
		
		ModelAndView mav = new ModelAndView("createemployee", "createemployeebean", new CreateEmployeeBean());
		mav.addObject("department",department);
		mav.addObject("job",job);
		return mav;
	}	
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createNewShop(@ModelAttribute(value="createemployeebean") @Valid CreateEmployeeBean createemployeebean,
			BindingResult result2,
			final RedirectAttributes redirectAttributes) {
		
		
		
		if (result2.hasErrors())
		{
			return onError();
		}
		try {
			empService.insertEmployee(createemployeebean);
		} catch (InvalidSalaryException e) {
			return onError();
		}		
		
		ModelAndView mav = new ModelAndView();
		String message = "New Employee "+createemployeebean.getFirstName()+" was successfully created.";
		

		mav.setViewName("redirect:/home.html");
				
		redirectAttributes.addFlashAttribute("message", message);	
		return mav;		
	}

	private ModelAndView onError() {
		List<Department> department = empService.findAllDepartments();
		List<Job> job = empService.findAllJobs();
		ModelAndView mav = new ModelAndView("createemployee");
		mav.addObject("department",department);
		mav.addObject("job",job);
		return mav;
	}	
	
	@RequestMapping(value={"/{id}/edit"}, method=RequestMethod.GET)
    
	public ModelAndView editEmployee(@PathVariable(value="id") Integer id ){
		List<Employee> findone = empService.findOneEmployee(id);
			
		
		
		ModelAndView mav = new ModelAndView("editemployee","employee", findone.get(0));
	
		
		return mav;
	}
	
	
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public ModelAndView updateEmployee(@ModelAttribute @Valid Employee employee, BindingResult result,final RedirectAttributes redirectAttributes ){
    	if (result.hasErrors())
			return new ModelAndView("editemployee");
    	
    	ModelAndView mav = new ModelAndView();
    	String message = "Employee "+employee.getFirstName()+" was successfully updated.";
    	
    	empService.updateEmployee(employee);
    	mav.setViewName("redirect:/home.html");
		redirectAttributes.addFlashAttribute("message", message);	
		return mav;		
		
	}
    
@RequestMapping(value={"/{id}/delete"}, method=RequestMethod.GET)
    
public ModelAndView deleteEmployee(@ModelAttribute @Valid Employee employee, BindingResult result,final RedirectAttributes redirectAttributes ){
	if (result.hasErrors())
		return new ModelAndView("employees");
	
	ModelAndView mav = new ModelAndView();
	String message = "Employee "+employee.getFirstName()+" was successfully deleted.";
	
	empService.deleteEmployee(employee);
	mav.setViewName("redirect:/home.html");
	redirectAttributes.addFlashAttribute("message", message);	
	return mav;		
    
    
    
} 



    
}

