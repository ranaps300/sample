package com.cg.mra.service;

//importing required package for validation

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.exception.MobileException;

//here we are implementing Service Layer Interface

public class AccountServiceImpl implements AccountService {

	
	AccountDao dao;
	public AccountServiceImpl(){
		
		//DAO Layer Object
		dao = new AccountDaoImpl();
	}
	
	//Overriding the method of Service Interface
	
	@Override
	public Account getAccountDetails(String mobileNo) {
		
		return dao.getAccountDetails(mobileNo);
	}

	@Override
	public double rechargeAccount(String mobileNo, double rechargeAmount) {
		
		return dao.rechargeAccount(mobileNo, rechargeAmount);
	}

	
	//Validation of the Inputs entered by the user
	//Mobile number validation
	
	@Override
	public boolean validateMobileNo(String mobileNo) throws MobileException {
		if(mobileNo == null)
			throw new MobileException("Invalid mobile No.");
		Pattern p = Pattern.compile("[6789][0-9]{9}");
		Matcher m = p.matcher(mobileNo);
		return m.matches();
		
	}
	
	// Recharge Amount Validation
	
	@Override
	public boolean validateRechargeAmount(double rechargeAmount) throws MobileException {
						
		if(rechargeAmount == 0)
			throw new MobileException("Null value found.");
		
		Double a = new Double(rechargeAmount);
		String amount = a.toString();
		return (amount.matches("\\d{1,4}\\.\\d{0,2}"));
		
	}
	
}