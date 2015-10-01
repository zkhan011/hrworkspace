package com.es.train.hr.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.es.example.hr.dto.Search;
import com.es.example.hr.model.Country;
import com.es.example.hr.model.Employee;
import com.es.example.hr.model.Location;
import com.es.example.hr.service.EmployeeSearchService;
import com.es.example.hr.service.EmployeeService;


@Controller
@RequestMapping("/search")
public class EmployeeSearchController {
	@Autowired
	private EmployeeSearchService empSearchService;

	@RequestMapping(value={"/searchbyname"}, method=RequestMethod.GET)
	
	public ModelAndView searchAllEmployees(){
		//List<Search> selectItems = new ArrayList<Search>();
		//List<Employee> employees = empSearchService.searchEmployee();
		List<Country> country = empSearchService.findAllCountries();
		List<Location> location = empSearchService.findAllLocations();
//		for (Country doc : country) {
//		     selectItems.add(new Search(doc.getId(),doc.getCountryName()));
//		}
ModelAndView mav= new ModelAndView("searchemployee","search",new Search());
    mav.addObject("country",country);
    mav.addObject("location",location);
    return mav;
		
}
	
	@RequestMapping(value={"/searchbyname"},method= RequestMethod.POST)
		
	public ModelAndView searchEmployee(@ModelAttribute @Valid Search search,
			BindingResult result1) {
		
		if (result1.hasErrors()){
			List<Location> location = empSearchService.findAllLocations();
			List<Country> country = empSearchService.findAllCountries();
		    ModelAndView mav= new ModelAndView("searchemployee");
			mav.addObject("location", location);
			mav.addObject("country",country);
			return mav;
		}
		
		 		
		int setFirstResult = 0;
	    int setLastResult = 5;
		
		List<Employee> emp=empSearchService.searchEmployee1(search.getCountryName(), search.getFirstName(),search.getLastName(),setFirstResult ,setLastResult);
	   
		ModelAndView mav = new ModelAndView("searchResult","employee",new Search());
		mav.addObject("details",emp);
//		List<Country> country = empSearchService.findAllCountries();
//		List<Location> location = empSearchService.findAllLocations();
//		//mav.setViewName("redirect:/home.html");
//		mav.addObject("location", location);
//		mav.addObject("country",country);		
		//redirectAttributes.addFlashAttribute("message", message);	
		return mav;		
	}	

	
	
	
	
	}