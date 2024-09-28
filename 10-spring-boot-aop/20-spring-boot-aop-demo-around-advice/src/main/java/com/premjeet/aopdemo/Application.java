package com.premjeet.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.premjeet.aopdemo.dao.AccountDAO;
import com.premjeet.aopdemo.dao.MembershipDAO;
import com.premjeet.aopdemo.service.TrafficFortuneService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, 
											   MembershipDAO theMembershipDAO,
											   TrafficFortuneService theTrafficFortuneService) {
		
		return runner -> {
			
			// demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			
			// demoTheAfterReturningAdvice(theAccountDAO);
			
			// demoTheAfterThrowingAdvice(theAccountDAO);
			
			// demoTheAfterAdvice(theAccountDAO);
			
			demoTheAroundAdvice(theTrafficFortuneService);
			
		};
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
		
		System.out.println("/nMain Program: demoTheAroundAdvice");
		
		System.out.println("Calling getFortune()");
		
		String data = theTrafficFortuneService.getFortune();
		
		System.out.println("\nMy fortune is: " + data);
		
		System.out.println("Finished");
		
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		
		// call method to find the accounts
		List<Account> theAccounts = null;
		try {
			// add a boolean flag to simulate exception
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception exc) {
			System.out.println("\n\nMain Program: ... caught exception: " + exc);
		}
		
		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("---");
		
		System.out.println(theAccounts);
		System.out.println("\n");

		
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		
		// call method to find the accounts
				List<Account> theAccounts = null;
				try {
					// add a boolean flag to simulate exception
					boolean tripWire = true;
					theAccounts = theAccountDAO.findAccounts(tripWire);
				} catch (Exception exc) {
					System.out.println("\n\nMain Program: ... caught exception: " + exc);
				}
				
				// display the accounts
				System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
				System.out.println("---");
				
				System.out.println(theAccounts);
				System.out.println("\n");
		
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		
		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterAdvice");
		System.out.println("---");
		
		System.out.println(theAccounts);
		System.out.println("\n");
		
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		
		// call the business method
		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");
		
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		
		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		// call the member business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
	}
}
