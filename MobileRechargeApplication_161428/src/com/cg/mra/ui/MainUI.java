
package com.cg.mra.ui;

//Packages imported as required
import java.util.Scanner;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.MobileException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

//Main Class define in UI layer

public class MainUI {
	public static void main(String args[]) throws MobileException{
		//Creating Service Layer Object to use the methods
		AccountService service = new AccountServiceImpl();
		
		Scanner sc = new Scanner(System.in);
		
		int ch = 0;
		
		String mobileNo;
		double rechargeAmount;
		
		Account account;
		//Providing the service to user
		do{
			
			System.out.println("Press\n1.Account Balance Enquiry\n2.Recharge Account\n3.Exit");
			ch = sc.nextInt();
			//Switch case use for the basis of the user input
			switch(ch){
				
				//Getting the details of the mobile number entered by the user
			
				case 1 :
						do{
							System.out.println("Enter Mobile No : ");				
							mobileNo = sc.next();
							//validation of the mobile number
							if(service.validateMobileNo(mobileNo))
								break;							
							else
								System.out.println("Invalid Details Provided.");
						}while(true);
						
						account = service.getAccountDetails(mobileNo);
						//checking if  mobile number exist
						if(account != null)
							System.out.println("Your Current balance is Rs. "+account.getAccountBalance());
						else
							System.out.println("ERROR: Given Account Id Does Not Exist");
					
					break;
					
					
				//Getting recharge done by amount and mobile number entered by the user
					
				case 2 :							
						
						do{
							System.out.println("Enter MobileNo : ");
							mobileNo = sc.next();
							
							//validating mobile number and checking if it exist in hte HashMap
							
							if(service.validateMobileNo(mobileNo) && service.getAccountDetails(mobileNo) != null)
								break;
							else
								System.out.println("ERROR: Cannot Recharge Account as given Mobile No Does Not Exist");
							
						}while(true);
						
						do{
							//validating the amount enterd by the user
							System.out.println("Enter Recharge Amount : ");
							rechargeAmount = sc.nextDouble();
							
							if(service.validateRechargeAmount(rechargeAmount))
								break;
							else
								System.out.println("ERROR: Invalid Recharge Amount Details.");
						}while(true);
					
					
						double newAccountBalance = service.rechargeAccount(mobileNo, rechargeAmount);
						
						//Printing the details of the updated amount balance
						
						System.out.println("Your Account Recharged Successfully");
						
						account = service.getAccountDetails(mobileNo);
						System.out.println("Hello "+ account.getCustomerName() + ", Available Balance is "+ newAccountBalance+" .");				
					
						
					break;
					
				case 3 :
						System.out.println("Thankyou..!");
					break;	
			
				default : System.out.println("Invalid input!");
			}
			
		}while(ch!=3);		
		
	}
	
}