package com.capgemini.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.capgemini.bank.bean.BeanAccount;
import com.capgemini.bank.exceptions.*;

public interface DaoAccountInterface {
	public void createAccountDao(String accountNumber, BeanAccount user) throws SQLException;
	public BeanAccount viewAccount(String accountNumber) throws InvalidAccountException, Exception;
	public void addMoney(String accountNumber, int amount) throws InvalidAccountException, SQLException, Exception;
	public void transfer(String accountNumber1,String accountNumber2, int amount) throws InsuffecientAmountException, InvalidAccountException, InvalidDetailsException, SQLException, Exception;
	public void validateAccount(String accountNumber) throws InvalidAccountException, Exception;
	public void checkSameAccount(String accountNumber1,String accountNumber2)throws InvalidDetailsException ;
	public void checkSuffecientBalance(String accountNumber1, int amount) throws InsuffecientAmountException, Exception;
	public ResultSet getAllAccounts() throws Exception;
	

}
