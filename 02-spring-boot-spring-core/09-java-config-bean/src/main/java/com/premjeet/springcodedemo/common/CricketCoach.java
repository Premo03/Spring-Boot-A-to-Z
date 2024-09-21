package com.premjeet.springcodedemo.common;
import org.springframework.stereotype.Component;


@Component
public class CricketCoach implements Coach {

	public CricketCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}
		
	@Override
	public String getDailyWorkout() {
		return "Practice fast batting for next 15 minutes!";
	}
}
