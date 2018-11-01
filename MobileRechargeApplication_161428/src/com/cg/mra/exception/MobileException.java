package com.cg.mra.exception;

//it will extend the base class excp to handle the expn msg 

public class MobileException extends Exception {
	
	public MobileException(String message){
		super(message);
	}

}
