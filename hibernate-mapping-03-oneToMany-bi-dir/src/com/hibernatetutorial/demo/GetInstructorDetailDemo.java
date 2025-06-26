package com.hibernatetutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.entity.Instructor;
import com.hibernatetutorial.entity.InstructorDetail;
import com.hibernatetutorial.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {

			// start a  transaction
			session.beginTransaction();

			//get the instructor detail object
			int theId=2;
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);			
			
			//print the instructor detail object
			
			System.out.println("Instructor Detail : " + instructorDetail); 
			
			//print the associated Instructor
			System.out.println("Associated Instructor: " + instructorDetail.getInstructor());
			
			//deleting the instructor detail object and hence causing associated instructor to get deleted
			session.delete(instructorDetail);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			System.out.println("Inside finally block");
			session.close();
			factory.close();
		}
	}
}
