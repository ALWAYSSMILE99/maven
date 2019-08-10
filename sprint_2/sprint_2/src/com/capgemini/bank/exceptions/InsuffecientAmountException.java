package com.capgemini.bank.exceptions;

@SuppressWarnings("serial")
public class InsuffecientAmountException extends Exception{
	public InsuffecientAmountException() {
		super("The Sender Acoount Balance is not suffecient");
	}

}
