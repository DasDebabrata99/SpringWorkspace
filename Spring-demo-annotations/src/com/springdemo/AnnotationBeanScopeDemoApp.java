package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		//load spring file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		//retrieve bean
		Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("thatSillyCoach", Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		System.out.println(result);
		
		System.out.println(theCoach);
		System.out.println(alphaCoach);
		

	}

}
