package com.springdemo;

public class CricketCoach implements Coach {

	FortuneService fortuneService ;
	
	public void doMyStartupStuff() {
		System.out.println(" Invoking init method post construction of object ");
	}
	
	public void doMyCleanupStuff() {
		System.out.println(" Invoking destroy method pre destruction of object ");
	}
	
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "bowl for 90 mins";
	}
	
	
	
	public void setFortuneService( FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		
		return this.fortuneService.getFortune();
	}

}
