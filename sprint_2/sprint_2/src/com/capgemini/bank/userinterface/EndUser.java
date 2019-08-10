package com.capgemini.bank.userinterface;

import java.sql.ResultSet;
import java.util.Scanner;

import com.capgemini.bank.bean.BeanAccount;
import com.capgemini.bank.service.AccountServiceImpl;



public class EndUser {
	
	
	static AccountServiceImpl service=new AccountServiceImpl();
	
	public static void showMenu() {
		
		System.out.println("01.CREATE AN ACCOUNT ");
		
		System.out.println("02. ADD MONEY TO ACCOUNT");
		
		System.out.println("03. SHOW DETAILS OF ACCOUNT");
		
		System.out.println("04. TRANSFER MONEY FROM ONE ACCOUNT TO ANOTHER");
		
		System.out.println("05. DISPLAY ALL ACCOUNTS");
		
		System.out.println("06. EXIT");
		
		System.out.print("Enter Your Choice : ");
	}
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int choice;
		
		while(true)
		{
			showMenu();
			choice = scanner.nextInt();
			switch(choice)
			{
			
			
			case 1:
				
				System.out.println("CREATE AN ACCOUNT");
				try
				{
					BeanAccount user=new BeanAccount();
					
					System.out.println("NAME:");
					
					user.setName(scanner.next());
					
					System.out.println("VALID MOBILE NUMBER:");
					
					user.setPhoneNumber(scanner.nextLong());
					
					System.out.println("EMAIL:");
					
					user.setEmailid(scanner.next());
					
					user.setBalance(0);
					
					String AccountNumber=service.createAccountDao(user);
					
					System.out.println("YOUR GENERATED ACCOUNT NUMBER IS : "+AccountNumber);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				break;
				
			case 2:
				
				System.out.println("ADD MONEY TO ACCOUNT");
				
				try {
					
					System.out.println("ENTER THE EXISTING ACCOUNT NUMBER:");
					
					String AccountNumber=scanner.next();
					
					System.out.println("ENTER AN AMOUNT VALUE TO BE ADDED"+AccountNumber);
					
					int Amount=scanner.nextInt();
					
					service.addMoney(AccountNumber, Amount);
					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				break;
				
			case 3:
				
				System.out.println("SHOW DETAILS OF ACCOUNT");
				try
				{
					System.out.println("ENTER EXISTING ACCOUNT NUMBER");
					
					String AccountNumber=scanner.next();
					BeanAccount user=service.viewAccount(AccountNumber);
					
					System.out.println("USERNAME="+user.getName()+"\nCONTACTNUMBER="+user.getPhoneNumber()+"\nEMAIL="+user.getEmailid()+"\nBALANCE="+user.getBalance());
				}
				
				catch(Exception e)
				{
					System.out.println(e);
				}
				break;
				
			case 4:
				
				System.out.println("TRANSFER MONEY FROM ONE ACCOUNT TO ANOTHER");
				
				try
				
				{
					System.out.println("ACCOUNT NUMBER OF SENDER");
					
					String SenderAccountNumber=scanner.next();
					
					System.out.println("ACCOUNT NUMBER OF RECIEVER");
					
					String RecieverAccountNumber=scanner.next();
					
					System.out.println("ENTER THE AMOUNT YOU WANT TO SEND");
					
					int TransferAmount=scanner.nextInt();
					
					service.transfer(SenderAccountNumber, RecieverAccountNumber, TransferAmount);
					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				break;
				
			case 5:
				
				try
				
				{
					ResultSet rs=service.getAllAccounts();
					while(rs.next())
						
					{
						System.out.println("ACCOUNT NUMBER: "+rs.getString(1)+"\nUSERNAME: "+rs.getString(2));
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				break;
				
			case 6:
				
				System.exit(0);
			default:
				break;
			}
		}
	}

}
