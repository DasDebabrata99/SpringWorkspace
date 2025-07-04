package com.hibernatetutorial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {

	// define fields and annotate them
	@Id
	@Column(name="id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int id;	
	
	@Column(name="comment")
	String comment;
	
	//define constructor
	public Review() {
		// TODO Auto-generated constructor stub
	}
	
	public Review(String comment) {
		super();
		this.comment = comment;
	}	
	//getter and setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + "]";
	}
	
	
}
