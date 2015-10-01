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
@Table(name="COUNTRIES")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="COUNTRY_ID", nullable = false)
	private String id;	
	
	@Column(name="COUNTRY_NAME", nullable = false)
	private String countryName;	
	
	@OneToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name="REGION_ID", nullable=false)	
	private Region region;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}	
}
