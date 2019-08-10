package UserInterface;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import bean.BeanAccount;
import service.ServiceAccountImplements;

public class EndUser {
	static ServiceAccountImplements service=new ServiceAccountImplements();
	public static void showMenu() {
		
		
		System.out.println("1 CREATE AN ACCOUNT");
		
		System.out.println("2 ADD MONEY TO ACCOUNT");
		
		System.out.println("3 SHOW DETAILS OF ACCOUNT");
		
		System.out.println("4 TRANSFER MONEY FROM ONE ACCOUNT TO ANOTHER");
		
		System.out.println("5 DISPLAY ALL ACCOUNTS");
		
		System.out.println("6 EXIT");
		
		System.out.print("SELECT AN OPTION : ");
	}
	
	public static void main(String[] args) {
		
		
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
					
					System.out.println("CONTACT NUMBER :");
					
					user.setContactNumber(scanner.nextLong());
					
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
					
					System.out.println("ENTER AN AMOUNT VALUE TO BE ADDED "+AccountNumber);
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
					
					System.out.println("USERNAME="+user.getName()+"\nCONTACTNUMBER="+user.getContactNumber()+"\nEMAIL="+user.getEmailid()+"\nAMOUNT="+user.getBalance());
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
					
					System.out.println("ENTER THE AMOUNT YO WANT TO SEND");
					
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
					Map<String, BeanAccount> userlist=new HashMap<String, BeanAccount>();
					
					userlist=service.getAllAccounts();
					
					if(!userlist.isEmpty())
					{
						

						Set<Entry<String, BeanAccount>> set=userlist.entrySet();
						
						Iterator<Entry<String, BeanAccount>> i=set.iterator();
						
						while(i.hasNext())
						{
							Map.Entry<String, BeanAccount> me=(Map.Entry<String, BeanAccount>)i.next();
							
							BeanAccount result=me.getValue();
							
							System.out.println("ACCOUNT NUMBER: "+me.getKey()+"\nNAME: "+result.getName());
						}
					}
					else
					{
						System.out.println("ACCOUNT NOT FOUND PLEASE CHECK AGAIN");
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
