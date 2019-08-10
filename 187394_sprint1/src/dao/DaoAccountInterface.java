package dao;

import java.util.HashMap;

import Exceptions.InsuffecientAmountException;
import Exceptions.InvalidAccountException;
import bean.BeanAccount;

public interface DaoAccountInterface {
	
	
	
	public void createAccountDao(String AccountNumber, BeanAccount user);
	
	
	public BeanAccount viewAccount(String AccountNumber) throws InvalidAccountException;
	
	public void addAmount(String AccountNumber, int Amount) throws InvalidAccountException;
	
	public void transfer(String AccountNumber1,String AccountNumber2, int Amount) throws InsuffecientAmountException, InvalidAccountException;
	public void validateAccount(String accountNumber) throws InvalidAccountException;
	
	public void checkBalance(String accountNumber1, int amount) throws InsuffecientAmountException;
	
	public HashMap<String, BeanAccount> getAllAccounts();
	

}
