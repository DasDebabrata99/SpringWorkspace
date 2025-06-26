package com.hibernatetutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.entity.Course;
import com.hibernatetutorial.entity.Instructor;
import com.hibernatetutorial.entity.InstructorDetail;
import com.hibernatetutorial.entity.Student;

public class CreateCousesDemo {
	
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//begin transaction
			session.beginTransaction();
			
			//get instructor from db
			int instructor_id=4;
			Instructor myInstructor=session.get(Instructor.class, instructor_id);

			//create a courses objects
			Course course1 = new Course("Table tennis - novice to champion");			
			Course course2 = new Course("Swimming - you will cross teh English Channel");
			
			//add courses to instructor
			myInstructor.addCourse(course1);
			myInstructor.addCourse(course2);
						
			//save the courses object
			//			it will also save the details object
			// because of CascadeType.all
			
			session.save(course1);
			session.save(course2);
			
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
