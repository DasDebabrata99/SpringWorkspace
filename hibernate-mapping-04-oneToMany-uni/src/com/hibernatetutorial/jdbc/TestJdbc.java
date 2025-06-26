package com.hibernatetutorial.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.hibernatetutorial.entity.Student;

public class TestJdbc {

	
//	public static void main(String[] args) {
//		
//		String jdbcurl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
//		String username="root";
//		String password="Arcind@123";
//		try {
//			Connection myConn = DriverManager.getConnection(jdbcurl,username, password);
//			//Statement myStatement = myConn.createStatement();
//			System.out.println("connection successfull!");
//						
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
//	public static void main(String[] args) {
//	     Student user1 = new Student();
//	      
//	        user1.setId(1);
//	        user1.setFirstname("Dinesh Rajput");
//	        
//	            
//	       // Create Session Factory Object  – using annotation configuration object
//	        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); 
//	   
//	      //Create Session object from session factory object
//	        Session session = sessionFactory.openSession();
//	        session.beginTransaction();
//	   
//	       //Use the session to save model objects
//	        session.save(user1);
//	        
//	        session.getTransaction().commit();
//	        session.close();
//	}
}
