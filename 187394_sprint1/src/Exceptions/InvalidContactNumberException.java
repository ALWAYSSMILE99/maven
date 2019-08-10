package Exceptions;

public class InvalidContactNumberException extends Exception{
	public InvalidContactNumberException()
	{
		super("PLEASE PROVIDE A VALID NUMBER");
	}

}
