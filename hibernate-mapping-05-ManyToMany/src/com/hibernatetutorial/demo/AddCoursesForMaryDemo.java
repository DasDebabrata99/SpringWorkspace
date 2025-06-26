package com.hibernatetutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.entity.Course;
import com.hibernatetutorial.entity.Instructor;
import com.hibernatetutorial.entity.InstructorDetail;
import com.hibernatetutorial.entity.Review;
import com.hibernatetutorial.entity.Student;

public class AddCoursesForMaryDemo {
	
	
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
			int theStudentId=14;
			
			//get student
			
			Student student = session.get(Student.class, theStudentId);
			
			//create course
			Course course1 = new Course("Rubik's cube ");
			Course course2 = new Course("Atari Game development ");
			
			course1.addStudent(student);
			course2.addStudent(student);
			
			
			
			session.save(student);
			//session.save(course2);
			
			System.out.println(student);
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
