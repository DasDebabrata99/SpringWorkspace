package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanlifecycle-application-context.xml");

		Coach theCoach1 = context.getBean("mycoach", Coach.class);				
		Coach theCoach2 = context.getBean("mycoach", Coach.class);
		boolean result = (theCoach1 == theCoach2);
		
		System.out.println("Are they both same instance : " + result);
		System.out.println("Memory location for theCoach1: " + theCoach1);
		
		System.out.println("Memory location for theCoach2: " + theCoach2);
		context.close();
	}

}
