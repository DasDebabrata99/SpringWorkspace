package com.hibernatetutorial.demo;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernatetutorial.entity.Course;
import com.hibernatetutorial.entity.Instructor;
import com.hibernatetutorial.entity.InstructorDetail;


public class FetchJoinDemo {
	
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int instructor_id=4;
			//begin transaction
			session.beginTransaction();
			//option 2 using hql
			Query<Instructor> query = session.createQuery("select i from instructor i"
					+ "Join Fetch i.courses"
					+ "where i.id=:theinstructorId ", Instructor.class);
			query.setParameter("theinstructorId", instructor_id);
			//get instructor from db
			
			//execute query
			Instructor myInstructor = query.getSingleResult();

			System.out.println("luv2code:  Instructor:" + myInstructor);		
	
			System.out.println("Course"+ myInstructor.getCourses());
			
			//session.delete(theInstructor);
			//commiit transaction
			session.getTransaction().commit();
			System.out.println("luv2code :  done");
			
		}finally {
			
			session.close();
			factory.close();
		}
	}
}
