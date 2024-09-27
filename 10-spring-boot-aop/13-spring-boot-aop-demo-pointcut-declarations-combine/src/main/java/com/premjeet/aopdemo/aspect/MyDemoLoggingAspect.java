package com.premjeet.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	
	@Pointcut("execution(* com.premjeet.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// create a pointcut for getter method
	@Pointcut("execution(* com.premjeet.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// create a pointcut for setter method
	@Pointcut("execution(* com.premjeet.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// create a pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on method <<<=====");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytices( ) {
		
		System.out.println("\n=====>>> Performing API analytics <<<=====");
	}
}
