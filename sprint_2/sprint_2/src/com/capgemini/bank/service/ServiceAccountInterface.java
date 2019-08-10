package com.capgemini.bank.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.capgemini.bank.bean.BeanAccount;
import com.capgemini.bank.exceptions.*;

public interface ServiceAccountInterface {
	public String createAccountDao(BeanAccount user) throws IncorrectMailFormatException, InvalidContactNumberException, SQLException, Exception;
	public BeanAccount viewAccount(String accountNumber) throws InvalidAccountException, Exception;
	public void addMoney(String accountNumber, int amount) throws InvalidAccountException, SQLException, Exception;
	public void transfer(String accountNumber1,String accountNumber2, int amount) throws InsuffecientAmountException, InvalidAccountException, InvalidDetailsException, Exception;
	public ResultSet getAllAccounts() throws Exception;
}
