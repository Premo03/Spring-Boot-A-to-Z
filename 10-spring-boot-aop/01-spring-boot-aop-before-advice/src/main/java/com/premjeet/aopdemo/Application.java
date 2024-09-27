package com.premjeet.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.premjeet.aopdemo.dao.AccountDAO;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO) {
		
		return runner -> {
			
			demoTheBeforeAdvice(theAccountDAO);
			
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO) {
		
		// call the business method
		theAccountDAO.addAccount();
		
		// do it again!
		System.out.println("\n let's call it again!\n");
		
		// call the business method again
		theAccountDAO.addAccount();
		
	}
}
