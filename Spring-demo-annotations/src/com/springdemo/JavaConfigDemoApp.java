package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		//read spring configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		//get the bean from spring container
		Coach theCoach=context.getBean("tennisCoach", Coach.class);
		
		//call a methpd on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getFortuneService());
		//close the context
		context.close();
	}

}
