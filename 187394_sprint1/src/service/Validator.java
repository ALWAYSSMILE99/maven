package service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Exceptions.*;
import bean.BeanAccount;
public class Validator {
	boolean result=false;
	boolean result01=false;
	boolean result02=false;
	public void validator(BeanAccount user) throws IncorrectMailFormatException,InvalidContactNumberException
	{
		try {
			validateContactNumber(user.getContactNumber());
			validateEmail(user.getEmailid());
			
		} catch (InvalidContactNumberException | IncorrectMailFormatException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	public void validateEmail(String string) throws IncorrectMailFormatException
	{
		try
		{
			Pattern p = Pattern.compile("\\b[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b");
			Matcher m = p.matcher(string);
			if(!m.matches())
			{
				throw new IncorrectMailFormatException();
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	public void validateContactNumber(long phone) throws InvalidContactNumberException
	{
		try
		{
			String temp=String.valueOf(phone);
			Pattern p = Pattern.compile("\\d{10}");
			Matcher m = p.matcher(temp);
			if(!m.matches() || (!(temp.length()==10)))
			{
				throw new InvalidContactNumberException();
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
}
