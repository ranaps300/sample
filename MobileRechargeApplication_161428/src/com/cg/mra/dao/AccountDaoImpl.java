package com.cg.mra.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.mra.beans.Account;

//inheriting the DAO Interface

public class AccountDaoImpl implements AccountDao{
	
	Map<String, Account> accountEntry;
	
	Account account;
	//Constructor to initialize HashMap
	public AccountDaoImpl(){
		
		accountEntry = new HashMap<>();
		
		accountEntry.put("9010210131", new Account("Prepaid", "Vaishali", 200));
		accountEntry.put("9823920123", new Account("Prepaid", "Megha", 453));
		accountEntry.put("9932012345", new Account("Prepaid", "Vikas", 631));
		accountEntry.put("9010210131", new Account("Prepaid", "Vaishali", 200));
		accountEntry.put("9010210133", new Account("Prepaid", "Tushar", 632));
		
	}

	//Overriding the interface methods
	
	@Override
	public Account getAccountDetails(String mobileNo) {
		
		account = accountEntry.get(mobileNo);
		return account;
	
	}

	@Override
	public double rechargeAccount(String mobileNo, double rechargeAmount) {
		account = accountEntry.get(mobileNo);
		if(account != null){
			double newAccountBalance = account.getAccountBalance() + rechargeAmount;  
			account.setAccountBalance(newAccountBalance);
			account.setCustomerName(account.getCustomerName());
			account.setAccountType("Prepaid");
			return newAccountBalance;
		}
		
		return 0;
	}

}