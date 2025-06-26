package com.hibernatetutorial.demo;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.entity.Student;


public class StudentDemo {
	
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//create a student object
			Student student1 = new Student("Jack","Daniels","jd@wy.com");
			//begin transaction
			session.beginTransaction();
			
			//save the student object
			session.save(student1);
			//commiit transaction
			session.getTransaction().commit();
			System.out.println("done");
		}finally {
			factory.close();
		}
	}
}
