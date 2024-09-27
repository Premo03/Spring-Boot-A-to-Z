package com.premjeet.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.premjeet.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Override
	public void addAccount(Account theAccount, boolean vipFlag) {

		System.out.println(getClass() + ":DOING MY DB WORK: ADDING AN ACCOUNT ");
		
	}

}
