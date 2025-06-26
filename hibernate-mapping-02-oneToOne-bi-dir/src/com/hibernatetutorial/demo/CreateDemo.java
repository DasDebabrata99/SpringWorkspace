package com.hibernatetutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.entity.Instructor;
import com.hibernatetutorial.entity.InstructorDetail;
import com.hibernatetutorial.entity.Student;

public class CreateDemo {

	
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//create a instructor object

//			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://j.r?youtube", "laws");
			Instructor myInstructor = new Instructor("jack", "reacher", "j.r@gmail.com");
			tempInstructorDetail.setInstructor(myInstructor);
			
			//myInstructor.setInstructorDetail(tempInstructorDetail);
				
			
			//deleting an instructor , will also delete the instructor detail object due to cascasde type all
			//int theId =1;
			
			
			//begin transaction
			session.beginTransaction();
			
			//Instructor theInstructor = session.get(Instructor.class, theId );
			
			//save the instructor object
//			it will also save the details object
			// because of CascadeType.all
			session.save(tempInstructorDetail);
			//session.save(myInstructor);
			//session.delete(theInstructor);
			//commiit transaction
			session.getTransaction().commit();
			System.out.println("done");
		}finally {
			factory.close();
		}
	}
}
