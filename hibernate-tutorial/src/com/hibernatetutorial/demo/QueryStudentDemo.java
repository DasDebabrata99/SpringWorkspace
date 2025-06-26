package com.hibernatetutorial.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.entity.Student;

public class QueryStudentDemo {

	
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//begin transaction
			session.beginTransaction();
			//query students
			List<Student> studentList = session.createQuery("from Student").getResultList();
			displayStudent(studentList);
			
			
			studentList = session.createQuery("from Student s where s.lastname='Daniels'").getResultList();
			displayStudent(studentList);
			//commiit transaction
			session.getTransaction().commit();
			System.out.println("done");
		}finally {
			factory.close();
		}
	}

	private static void displayStudent(List<Student> studentList) {
		for(Student student: studentList) {
			System.out.println(student);
		}
	}
}
