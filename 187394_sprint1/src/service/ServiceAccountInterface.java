package service;

import java.util.HashMap;

import Exceptions.*;
import bean.BeanAccount;

public interface ServiceAccountInterface {
	public String createAccountDao(BeanAccount user) throws InvalidDetailsException, IncorrectMailFormatException, InvalidContactNumberException;
	public BeanAccount viewAccount(String AccountNumber) throws InvalidAccountException;
	public void addMoney(String AccountNumber, int Amount) throws InvalidAccountException;
	public void transfer(String AccountNumber1,String AccountNumber2, int Amount) throws InsuffecientAmountException, InvalidAccountException;
	public HashMap<String, BeanAccount> getAllAccounts();
}
