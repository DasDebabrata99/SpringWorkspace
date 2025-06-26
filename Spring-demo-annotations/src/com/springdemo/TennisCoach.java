package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("tennisCoach")
public class TennisCoach implements Coach {
 
	@Autowired
	@Qualifier("randomFortuneService")
	FortuneService fortuneService;
	
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		System.out.println("Constructor injection");
//		this.fortuneService = fortuneService;
//	}

	
	
//	  @Autowired public void setFortuneService(FortuneService fortuneService) {
//		  System.out.println("Setter injection");
//		  this.fortuneService = fortuneService; 
//	  }
	 

//	@Autowired
//	public void doSomeCrazyStuff(FortuneService fortuneService) {
//		System.out.println("Method injection");
//		this.fortuneService = fortuneService;
//	}


	@Override
	public String getFortuneService() {
		return this.fortuneService.getFortune();
	}

	@Override
	public String getDailyWorkout() {

		return "keep practicing back hand volley";
	}
}