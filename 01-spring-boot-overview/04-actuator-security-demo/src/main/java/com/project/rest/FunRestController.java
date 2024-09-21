package com.project.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
		@GetMapping("/")
		public String sayHello() {
			return "Hello Guys";
		}
		
		@GetMapping("/workout")
		public String dailyWorkout() {
			return "Hard to run 5KM !";
		}
		
		@GetMapping("/fortune")
		public String dailyFortune() {
			return "From now you all days are lucky!!";
		}
}
