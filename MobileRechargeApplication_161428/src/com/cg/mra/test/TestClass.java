package com.cg.mra.test;

//importing packages requiered for unit testing

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.cg.mra.exception.MobileException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class TestClass {

	//creation of Service Layer Object
	
	AccountService service = new AccountServiceImpl();
	double amount;
	boolean result;
	String mobileNo;
	
	//Test of Amount Validation
	
	//Testing for null/0 values
	@Test(expected=MobileException.class)
	public void test_Validate_Amount_Null() throws MobileException{
		service.validateRechargeAmount(0);	
		
	}
	
	//Test for invalid amount i.e less than 0
	@Test
	public void test_Validate_Amount_Negative_Values() throws MobileException{
		amount  = -100;
		result = service.validateRechargeAmount(amount);
		Assert.assertEquals(false,result);
	}
	
	
	//Test for invalid amount i.e greater tha 4-digit number
	@Test
	public void test_Validate_Amount_Greater_Values() throws MobileException{
		amount  = 100000;
		result = service.validateRechargeAmount(amount);
		Assert.assertEquals(false,result);
	}
	
	//Test for correct values
	@Test
	public void test_Validate_Amount_Correct_Values() throws MobileException{
		amount  = 300;
		result = service.validateRechargeAmount(amount);
		Assert.assertEquals(true,result);
	}
	
	//Testing for mobile number
	
	//Test for Null values
	@Test(expected=MobileException.class)
	public void test_Validate_Mobile_Null() throws MobileException{
		service.validateMobileNo(null);	
	}
	
	//Test for digits less than 10
	@Test
	public void test_Validate_Mobile_V1() throws MobileException{
		mobileNo = "12345";
		result = service.validateMobileNo(mobileNo);
		Assert.assertEquals(false,result);
	}
	
	//Test for Digits that starts excepts '6, 7, 8, 9' 
	@Test
	public void test_Validate_Mobile_V2() throws MobileException{
		mobileNo = "1234567890";
		result = service.validateMobileNo(mobileNo);
		Assert.assertEquals(false,result);
	}
	//test for including alphanumeric characters
	@Test
	public void test_Validate_Mobile_V3() throws MobileException{
		mobileNo = "1245ahsgu";
		result = service.validateMobileNo(mobileNo);
		Assert.assertEquals(false,result);
	}
	
	
	//Test for entering negative numbers
	@Test
	public void test_Validate_Mobile_V4() throws MobileException{
		mobileNo = "-9612345";
		result = service.validateMobileNo(mobileNo);
		Assert.assertEquals(false,result);
	}
	
	//test for correct mobile number
	
	@Test
	public void test_Validate_Mobile_V5() throws MobileException{
		mobileNo = "7021540643";
		result = service.validateMobileNo(mobileNo);
		Assert.assertEquals(true,result);
	}
	
}
