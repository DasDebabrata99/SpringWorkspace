package com.springdemo;

public class BaseballCoach implements Coach{
	
	private FortuneService myFortuneService;
	
	public BaseballCoach(FortuneService  myFortuneService) {
		
		this.myFortuneService=myFortuneService;
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Swing bat for 30min";
	}

	@Override
	public String getDailyFortune() {

		return myFortuneService.getFortune();
	}
}
