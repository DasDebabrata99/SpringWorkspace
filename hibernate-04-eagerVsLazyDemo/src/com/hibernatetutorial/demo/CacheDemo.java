package com.hibernatetutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.entity.Course;
import com.hibernatetutorial.entity.Instructor;
import com.hibernatetutorial.entity.InstructorDetail;

/**
 * @author debabratad
 *
 */
public class CacheDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		demoFirstLevelCache(sessionFactory);
		
	}
	
	public static void demoFirstLevelCache(SessionFactory sessionFactory) {
		
		Session session1 = sessionFactory.openSession();
		Instructor instructor1 = session1.get(Instructor.class, 1);
		instructor1.setFirstname("bhondu");
		System.out.println(instructor1);
		System.out.println("hashcode of 1st object " + instructor1.hashCode());
		
		Session session2 = sessionFactory.openSession();
		Instructor instructor2 = session2.get(Instructor.class, 1);
		System.out.println(instructor2);
		System.out.println("hashcode of 2nd object " + instructor2.hashCode());
		
	}
}
