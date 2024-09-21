package com.premjeet.springcodedemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.premjeet.springcodedemo.common.Coach;

@RestController
public class DemoController {
	//define a private field for the dependency injection
	
	private Coach myCoach;
	
	@Autowired
	public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
		myCoach = theCoach;
	}
	
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
}
