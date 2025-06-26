package com.hibernatetutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.entity.Course;
import com.hibernatetutorial.entity.Instructor;
import com.hibernatetutorial.entity.InstructorDetail;
import com.hibernatetutorial.entity.Review;

public class DeleteCourseAndReviewDemo {
	
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//begin transaction
			session.beginTransaction();
			
			//get the course
			int course_id=3;
			
			Course course = session.get(Course.class, course_id);
			
			//delete the course
			session.delete(course);
			
			//commiit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
		}finally {
			
			session.close();
			factory.close();
		}
	}
}
