package com.premjeet.springcodedemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

	@Override
	public String getDailyWorkout() {

		return "Practice your backend volley.";
	}

}
