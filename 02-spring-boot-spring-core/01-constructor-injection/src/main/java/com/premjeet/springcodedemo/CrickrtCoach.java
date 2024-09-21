package com.premjeet.springcodedemo;

import org.springframework.stereotype.Component;

@Component
public class CrickrtCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast batting for next 15 minutes!!";
	}
}
