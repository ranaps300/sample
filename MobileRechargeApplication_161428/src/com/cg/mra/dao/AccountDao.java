package com.cg.mra.dao;

import com.cg.mra.beans.Account;

//this is the interface
public interface AccountDao {
	
	//declaring methods for interface
	public Account getAccountDetails(String mobileNo);
	
	public double rechargeAccount(String mobileNo, double rechargeAmount);

}
