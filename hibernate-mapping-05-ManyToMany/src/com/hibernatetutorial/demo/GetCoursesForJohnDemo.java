package com.hibernatetutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.entity.Course;
import com.hibernatetutorial.entity.Instructor;
import com.hibernatetutorial.entity.InstructorDetail;
import com.hibernatetutorial.entity.Review;
import com.hibernatetutorial.entity.Student;

public class GetCoursesForJohnDemo {
	
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//begin transaction
			session.beginTransaction();
			int theStudentId=12;
			
			//get student
			
			Student student = session.get(Student.class, theStudentId);
			
			System.out.println("My Student: " + student);
			System.out.println("My Course: " + student.getCourses());
			
			session.save(student);
			//session.save(course2);
			
			//session.save(student2);
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
