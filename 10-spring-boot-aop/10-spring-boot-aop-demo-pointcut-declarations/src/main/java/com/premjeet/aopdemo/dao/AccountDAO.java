package com.premjeet.aopdemo.dao;

import com.premjeet.aopdemo.Account;

public interface AccountDAO {
	
	void addAccount(Account theAccount, boolean vipFlag);
	
	boolean doWork();

}	
