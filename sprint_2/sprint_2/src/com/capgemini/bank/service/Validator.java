package com.capgemini.bank.service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.bank.bean.BeanAccount;
import com.capgemini.bank.exceptions.*;
public class Validator {
	boolean result=false;
	boolean result1=false;
	boolean result2=false;
	public void validator(BeanAccount user) throws IncorrectMailFormatException,InvalidContactNumberException
	{
		try {
			validatePhoneNumber(user.getPhoneNumber());
			validateEmail(user.getEmailid());
			
		} catch (InvalidContactNumberException | IncorrectMailFormatException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	public void validateEmail(String string) throws IncorrectMailFormatException
	{
	
			Pattern p = Pattern.compile("\\b[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b");
			Matcher m = p.matcher(string);
			if(!m.matches())
			{
				throw new IncorrectMailFormatException();
			}
	
	}
	public void validatePhoneNumber(long phone) throws InvalidContactNumberException
	{
			String temp=String.valueOf(phone);
			Pattern p = Pattern.compile("\\d{10}");
			Matcher m = p.matcher(temp);
			if(!m.matches() || (!(temp.length()==10)))
			{
				throw new InvalidContactNumberException();
			}
	}
	
}
