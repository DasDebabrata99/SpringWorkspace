package com.hibernatetutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.entity.Course;
import com.hibernatetutorial.entity.Instructor;
import com.hibernatetutorial.entity.InstructorDetail;
import com.hibernatetutorial.entity.Review;
import com.hibernatetutorial.entity.Student;

public class CreateCourseAndStudentDemo {
	
	
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
			
			//create a course
			Course course = new Course("Delta Force : the rise");
			//add reviews to course
			
			//save course, since using cacade.all reviews will also get saved to database
			session.save(course);
			
			//add Students
			Student student1 = new Student("Johny", "Blaze", "j.b@barsum.com");
			Student student2 = new Student("Emily", "Clarke", "e.c@jassum.com");
			
			course.addStudent(student1);
			course.addStudent(student2);
			
			session.save(student1);
			session.save(student2);
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
