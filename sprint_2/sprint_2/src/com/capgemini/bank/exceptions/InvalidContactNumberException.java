package com.capgemini.bank.exceptions;
@SuppressWarnings("serial")
public class InvalidContactNumberException extends Exception{
	public InvalidContactNumberException()
	{
		super("The Phone number is in invalid Format");
	}

}
