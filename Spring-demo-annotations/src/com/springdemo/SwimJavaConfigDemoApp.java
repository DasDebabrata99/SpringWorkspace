package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		//read spring configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		//get the bean from spring container
		SwimCoach theCoach=context.getBean("swimCoach", SwimCoach.class);
		
		//call a methpd on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getFortuneService());
		
		System.out.println(theCoach.getEmail());
		
		System.out.println(theCoach.getTeam());
		//close the context
		context.close();
	}

}
