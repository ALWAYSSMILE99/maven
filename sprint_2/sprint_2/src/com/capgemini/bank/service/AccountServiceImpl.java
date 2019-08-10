package com.capgemini.bank.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;

import com.capgemini.bank.bean.BeanAccount;
import com.capgemini.bank.dao.DaoAccountInterface;
import com.capgemini.bank.dao.DaoAccountImplement;
import com.capgemini.bank.exceptions.InvalidAccountException;
import com.capgemini.bank.exceptions.InsuffecientAmountException;
import com.capgemini.bank.exceptions.InvalidDetailsException;
public class AccountServiceImpl extends Validator implements ServiceAccountInterface{
	DaoAccountInterface dao=new DaoAccountImplement();
	Validator v=new Validator();
	int row;
	@Override
	public String createAccountDao(BeanAccount user) throws Exception{
		// TODO Auto-generated method stub
		String accountNumber=null;
		try 
		{
			v.validator(user);
			Random rand=new Random();
			int num=rand.nextInt(9000000)+1000000;
			accountNumber=String.valueOf(num);
			dao.createAccountDao(accountNumber, user);
			return accountNumber;
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}


	@Override
	public BeanAccount viewAccount(String accountNumber) throws Exception{

		try
		{
			return dao.viewAccount(accountNumber);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	public void addMoney(String accountNumber, int amount) throws Exception {
		// TODO Auto-generated method stub
		try
		{
			dao.addMoney(accountNumber, amount);
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}

	@Override
	public void transfer(String accountNumber1, String accountNumber2, int amount) throws Exception {
		// TODO Auto-generated method stub
		try {
			dao.transfer(accountNumber1, accountNumber2, amount);
			}
		catch(Exception e)
		{
			throw e;
		}
		
	}


	@Override
	public ResultSet getAllAccounts() throws Exception {
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
