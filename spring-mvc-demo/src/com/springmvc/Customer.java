package com.springmvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.springmvc.validation.CourseCode;

public class Customer {

	private String firstname;
	
	@NotNull(message="is required")
	@Size(min=2, message="has to be more than 2 characters")
	private String lastname;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 alpha numeric characters allowed")
	private String postalCode;
	
	@NotNull (message="is required")
	private Integer freePasses;
	
	@CourseCode
	private String courseCode;
	
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
}
