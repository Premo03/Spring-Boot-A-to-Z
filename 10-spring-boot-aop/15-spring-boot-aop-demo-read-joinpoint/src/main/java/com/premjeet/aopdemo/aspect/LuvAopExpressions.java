package com.premjeet.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
	
	@Pointcut("execution(* com.premjeet.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	
	// create a pointcut for getter method
	@Pointcut("execution(* com.premjeet.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	
	// create a pointcut for setter method
	@Pointcut("execution(* com.premjeet.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	
	// create a pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
}
