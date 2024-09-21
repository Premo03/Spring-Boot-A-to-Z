package com.premjeet.springcodedemo.common;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class CricketCoach implements Coach {

	public CricketCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}
		
		// define our init method
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
	}
		
		// define our destroy method
	
	@PreDestroy
	public void myCleanupStuff() {
		System.out.println("In soMyCleanupStuff(): " + getClass().getSimpleName());
	}

	
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast batting for next 15 minutes!";
	}
}
