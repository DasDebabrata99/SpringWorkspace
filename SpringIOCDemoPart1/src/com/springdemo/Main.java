package com.springdemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		//load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");  
		
		//retrieve bean from spring container
		
		Coach thecoach = context.getBean("theCoach", Coach.class);
		//call methods on the bean
		
		System.out.println(thecoach.getDailyWorkout());
		System.out.println(thecoach.getDailyFortune());
		
	}
}
