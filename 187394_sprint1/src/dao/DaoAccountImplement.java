package dao;

import java.util.HashMap;
import java.util.Map;
import Exceptions.*;
import bean.BeanAccount;

public class DaoAccountImplement implements DaoAccountInterface{
	Map<String, BeanAccount> userHashMap=new HashMap<String, BeanAccount>();

	@Override
	
	public void createAccountDao(String accountNumber, BeanAccount user) {
		// TODO Auto-generated method stub
		try {
			userHashMap.put(accountNumber, user);
		}
		catch(Exception e)
		
		{
			throw e;
		}
		
	}

	@Override
	
	
	public BeanAccount viewAccount(String accountNumber) throws InvalidAccountException {
		// TODO Auto-generated method stub
		try {
			validateAccount(accountNumber);
			BeanAccount user=new BeanAccount();
			user=userHashMap.get(accountNumber);
			return user;
		}
		catch(Exception e) {
			
			throw e;
		}
	}

	@Override
	
	public void addAmount(String accountNumber, int amount) throws InvalidAccountException{
		// TODO Auto-generated method stub
		try {
			validateAccount(accountNumber);
			BeanAccount user=new BeanAccount();
			user=userHashMap.get(accountNumber);
			int temp=user.getBalance();
			temp=temp+amount;
			user.setBalance(temp);
			
		}
		catch(Exception e)
		{
			throw e;
		}
		
		
	}


	public void transfer(String accountNumber1, String accountNumber2, int amount) throws InsuffecientAmountException,InvalidAccountException {
		// TODO Auto-generated method stub
			try {
				
				validateAccount(accountNumber1);
				validateAccount(accountNumber2);
				checkBalance(accountNumber1, amount);
				BeanAccount user01=userHashMap.get(accountNumber1);
				BeanAccount user02=userHashMap.get(accountNumber2);
				int temp01=user01.getBalance();
				int temp02=user02.getBalance();
				temp01=temp01-amount;
				temp02=temp02+amount;
				user01.setBalance(temp01);
				user02.setBalance(temp02);
			}
			catch(Exception e)
			{
				throw e;
			}
		
			
	}
	
	
	@Override
	
	
	public void checkBalance(String accountNumber1, int amount) throws InsuffecientAmountException {
		// TODO Auto-generated method stub
		try {
			BeanAccount user=userHashMap.get(accountNumber1);
			if(user.getBalance()<amount)
			{
				throw new InsuffecientAmountException();
			}
		}
		catch(Exception e)
		{
			throw e;
			
			
		}
	}

	@Override
	
	
	public void validateAccount(String accountNumber) throws InvalidAccountException {
		// TODO Auto-generated method stub
		try
		{
			if(!userHashMap.containsKey(accountNumber))
			{
				throw new InvalidAccountException();
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	
	
	public HashMap<String, BeanAccount> getAllAccounts() {
		// TODO Auto-generated method stub
		try
		{
			return (HashMap<String, BeanAccount>) userHashMap;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}
