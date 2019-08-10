package Exceptions;

public class InvalidAccountException extends Exception{
	public InvalidAccountException()
	{
		super("ACCOUNT NUMBER DOES NOT EXIST");
	}

}
