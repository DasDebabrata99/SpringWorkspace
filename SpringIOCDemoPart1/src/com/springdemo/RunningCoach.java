package com.springdemo;

public class RunningCoach implements Coach {

	private FortuneService myFortuneService;

	public RunningCoach (FortuneService  myFortuneService) {
		
		this.myFortuneService=myFortuneService;
	}

	@Override
	public String getDailyFortune() {
		return myFortuneService.getFortune();
	}

	@Override
	public String getDailyWorkout() {

		return "run on track for hard 5k";

	}

}
