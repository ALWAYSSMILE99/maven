package com.capgemini.bank.exceptions;

@SuppressWarnings("serial")
public class InvalidAccountException extends Exception{
	public InvalidAccountException()
	{
		super("The Account Number is not found");
	}

}
