package com.capgemini.bank.bean;

public class BeanAccount {
	private String Name;
	private long ContactNumber;
	private String EmailId;
	private int Balance;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public long getPhoneNumber() {
		return ContactNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.ContactNumber = phoneNumber;
	}
	public String getEmailid() {
		return EmailId;
	}
	public void setEmailid(String emailid) {
		this.EmailId = emailid;
	}
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		this.Balance = balance;
	}

}
