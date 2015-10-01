package com.es.example.hr.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;


import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Tables;
import org.hibernate.validator.constraints.NotEmpty;




public class Search {
	
	
	private String location;
	
	@NotEmpty(message="must not be blank")
	private String firstName;
    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountryName() {
		return countryName;
	}
	
	
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	private String lastName;
	
	@NotEmpty(message="always selected")
	private String countryName;

}
