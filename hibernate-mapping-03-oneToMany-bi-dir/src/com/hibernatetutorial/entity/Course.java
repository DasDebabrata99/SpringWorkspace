package com.hibernatetutorial.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="course")
public class Course {

	/*
	 * 1. define fields
	 * 2. annotate the fields
	 * 3. define constructor
	 * 4. generate getter and setter
	 * 5. generate to String
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.DETACH , CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Course( String title) {
		super();
	
		this.title = title;
	
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	
}
