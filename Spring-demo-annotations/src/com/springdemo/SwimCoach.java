package com.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	FortuneService fortuneService;
	@Value("${foo.email}")
	public String email;
	@Value("${foo.team}")
	public String team;

	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}




	@Override
	public String getDailyWorkout() {
 
		return "Swim 1000m as a warm up";
	}

	@Override
	public String getFortuneService() {
		return fortuneService.getFortune();

	}

}
