package com.capgemini.bank.exceptions;
@SuppressWarnings("serial")
public class IncorrectMailFormatException extends Exception {
	public IncorrectMailFormatException()
	{
		super("The Email Format submitted is Invalid");
	}

}
