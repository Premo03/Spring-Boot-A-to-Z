package com.premjeet.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.premjeet.aopdemo.dao.AccountDAO;
import com.premjeet.aopdemo.dao.MembershipDAO;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		
		return runner -> {
			
			// demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			demoTheAfterAdvice(theAccountDAO);
			
		};
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		
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
