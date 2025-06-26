package com.springmvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private  String lastName;
	private  String country;
	private LinkedHashMap<String, String> countryOptions;
	private String favouriteLanguage;
	private LinkedHashMap<String, String> languageOptions;
	
	private String[] operatingSystems;
	private LinkedHashMap<String, String> osOptions;
	public Student(){
		countryOptions = new LinkedHashMap<String, String>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		
		languageOptions= new LinkedHashMap<String, String>();
		languageOptions.put("java","Java");
		languageOptions.put("C Sharp", "C#");
		languageOptions.put("ruby", "rubie");
		
		osOptions = new LinkedHashMap<String, String>();
		osOptions.put("Linux","ubuntu");
		osOptions.put("Windows","windows");
		osOptions.put("mac","MacOs");
	}

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public LinkedHashMap<String, String> getLanguageOptions() {
		return languageOptions;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public LinkedHashMap<String, String> getOsOptions() {
		return osOptions;
	}
	
	
}
