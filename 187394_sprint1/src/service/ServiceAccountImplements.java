package service;

import java.util.HashMap;
import java.util.Random;
import Exceptions.*;
import bean.BeanAccount;
import dao.*;
public class ServiceAccountImplements extends Validator implements ServiceAccountInterface{
	DaoAccountInterface dao=new DaoAccountImplement();
	Validator v=new Validator();
	@Override
	public String createAccountDao(BeanAccount user) throws  InvalidDetailsException, IncorrectMailFormatException, InvalidContactNumberException{
		// TODO Auto-generated method stub
		String AccountNumber=null;
		try 
		{
			v.validator(user);
			Random rand=new Random();
			int num=rand.nextInt(9000000)+1000000;
			 AccountNumber=String.valueOf(num);
			dao.createAccountDao(AccountNumber, user);
		}
		catch(Exception e)
		{
			throw e;
		}
		return AccountNumber;
		
	}


	@Override
	public BeanAccount viewAccount(String AccountNumber) throws InvalidAccountException{

		try
		{
			return dao.viewAccount(AccountNumber);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	public void addMoney(String AccountNumber, int Amount) throws InvalidAccountException {
		// TODO Auto-generated method stub
		try
		{
			dao.addAmount(AccountNumber, Amount);
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}

	@Override
	public void transfer(String AccountNumber1, String AccountNumber2, int Amount) throws InsuffecientAmountException,InvalidAccountException {
		// TODO Auto-generated method stub
		try {
			dao.transfer(AccountNumber1, AccountNumber2, Amount);
			}
		catch(Exception e)
		{
			throw e;
		}
		
	}


	@Override
	public HashMap<String, BeanAccount> getAllAccounts() {
		// TODO Auto-generated method stub
		try {
			return dao.getAllAccounts();
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}
