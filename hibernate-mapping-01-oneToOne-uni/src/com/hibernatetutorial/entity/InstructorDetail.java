package com.hibernatetutorial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="channel")
	private String youtube_channel;
	@Column(name="hobby")		
	private String hobby;
	
	public InstructorDetail() {
		
	}

	public InstructorDetail( String youtube_channel, String hobby) {
		this.youtube_channel = youtube_channel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutube_channel() {
		return youtube_channel;
	}

	public void setYoutube_channel(String youtube_channel) {
		this.youtube_channel = youtube_channel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtube_channel=" + youtube_channel + ", hobby=" + hobby + "]";
	}
	
	
}
