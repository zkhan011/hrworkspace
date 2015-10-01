package com.es.example.hr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="LOCATIONS")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="LOCATION_ID", nullable = false)
	private int id;	
	
	@Column(name="STREET_ADDRESS", nullable = false)
	private String streetAddress;	
	
	@Column(name="CITY", nullable = false)
	private String city;
	
	@Column(name="STATE_PROVINCE", nullable = false)
	private String state;

	@OneToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name="COUNTRY_ID", nullable=false)	
	private Country country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	
}
