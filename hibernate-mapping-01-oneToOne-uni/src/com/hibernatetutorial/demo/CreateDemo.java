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
			//create a student object
//			Instructor myInstructor = new Instructor("ravi", "kumar", "r.k@gmail.com");
//			
//				InstructorDetail tempInstructorDetail = new InstructorDetail("http://r.k?youtube", "luv2code");
			Instructor myInstructor = new Instructor("chad", "darby", "cha.darby@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://luv2code?youtube", "luv2code");
			myInstructor.setInstructorDetail(tempInstructorDetail);
			
			//deleting an instructor , will also delete the instructor detail object due to cascasde type all
//			int theId =1;
			
			
			//begin transaction
			session.beginTransaction();
			
//			Instructor theInstructor = session.get(Instructor.class, theId );
			
			//save the instructor object
//			it will also save the details object
			// because of CascadeType.all
			
			session.save(myInstructor);
//			session.delete(theInstructor);
			//commiit transaction
			session.getTransaction().commit();
			System.out.println("done");
		}finally {
			factory.close();
		}
	}
}
