package com.hibernatetutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.entity.Course;
import com.hibernatetutorial.entity.Instructor;
import com.hibernatetutorial.entity.InstructorDetail;
import com.hibernatetutorial.entity.Student;

public class CreateInstructorDemo {
	
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//create a instructor object
			Instructor myInstructor = new Instructor("susanne", "public", "susanne.public@gmail.com");			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://r.k?youtube", "gamer");

			myInstructor.setInstructorDetail(tempInstructorDetail);
			
			//begin transaction
			session.beginTransaction();
			
			//save the instructor object
			//			it will also save the details object
			// because of CascadeType.all
			
			session.save(myInstructor);
			//session.delete(theInstructor);
			//commiit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
		}finally {
			
			session.close();
			factory.close();
		}
	}
}
