package com.capgemini.bank.exceptions;
@SuppressWarnings("serial")
public class InvalidDetailsException extends Exception {
	public InvalidDetailsException()
	{
		super("the account numbers entered are same.");
	}

}
