package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		//read spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		//get the bean from spring container
		Coach theCoach=context.getBean("thatSillyCoach", Coach.class);
		
		//call a methpd on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getFortuneService());
		//close the context
		context.close();
	}

}
