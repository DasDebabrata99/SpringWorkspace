package com.hibernatetutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.entity.Course;
import com.hibernatetutorial.entity.Instructor;
import com.hibernatetutorial.entity.InstructorDetail;
import com.hibernatetutorial.entity.Review;

public class CreateCourseAndReviewDemo {
	
	
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
			
			//create a course
			Course course = new Course("Pacman");
			//add reviews to course
			course.addReview(new Review("great course. loved it!!"));
			course.addReview(new Review("Cool course.. job well done!"));
			course.addReview(new Review("what a dumb course!!"));
			
			//save course, since using cacade.all reviews will also get saved to database
			session.save(course);
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
