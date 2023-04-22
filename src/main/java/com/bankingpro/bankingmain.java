package com.bankingpro;
import java.util.*;

public class bankingmain{

	public static void main(String args[]) throws Exception
	{
		Scanner bs=new Scanner(System.in);
		bankingdao dao=new bankingdao();
		customer c1=new customer();
		
		
		System.out.println("\t\t\t********welcome to java bank********");
		System.out.println("press 1 to register\n press 2 to login");
		int op=bs.nextInt();
		
		switch(op)
		{
		case 1->
		{
			System.out.println("enter customer name");
			bs.nextLine();
			String  cname=bs.nextLine();
			System.out.println("enter customer id");
	        int cid=bs.nextInt();
	        System.out.println("enter customer pin");
	        int cpin=bs.nextInt();
	        System.out.println("enter customer amount ");
	        int camt=bs.nextInt();
	        
	        
	        c1.cusid=cid;
	        c1.cusname=cname;
	        c1.cuspin=cpin;
	        c1.cusamount=camt;
			
			
			//to get connection with db
			dao.dbconnection();
			//inserting user details ito db
			int res=dao.registercustomer(c1);
			
			
			//if insertion is success response is 1 otherwise 0
			if(res==1)
			{
				System.out.println("account created succesfully");	
			}
			else
			{
				System.out.println("something went wrong");
			}
		}
		case 2->
		{
			System.out.println("Welcome to Login Page");
			//reading username and password for login
			
			System.out.println("Enter Username");
			bs.nextLine();
			String uname=bs.nextLine();
			System.out.println("Enter Password");
			int pwd=bs.nextInt();
			
			//connecting to db
			dao.dbconnection();
			
			//login method
		    int res=dao.login(uname, pwd);
		    
			//handling the response
		    if(res==0)
		    {
		    	System.out.println("username/password is wrong");
		    }
		    else if(res==-1)
		    {
		    	System.out.println("account not existed");
		    }
		    else
		    {
		    	System.out.println("login successfull");
		    	System.out.println("press 1 to deposit\npress 2 to withdraw\npress 3 to change password\n press 4 to delete account" );
		    	int ops=bs.nextInt();
		    	
		    	switch(ops)
		    	{
		    	case 1->
		    	{
		    		System.out.println("Enter amount to deposit");
		    		int amount=bs.nextInt();
		    		
		    		int bal=dao.deposit(amount,res);
		    		System.out.println("Depsoit successful\n Available Amount is :"+bal);
		    	}
		    	case 2->
		    	{
		    		System.out.println("enter amount to withdraw");
		    		int amt=bs.nextInt();
		    		System.out.println("enter password for confirmation ");
		    		int confirmpwd=bs.nextInt();
		    		
		    		
		    		
		    		int bal=dao.withdraw(amt, confirmpwd, res);
		    		if(bal==0)
		    		{
		    			System.out.println("insufficient balance ");
		    		}
		    		else if(bal==-1)
		    		{
		    			System.out.println("wrong password ");
		    		}
		    		else
		    		{
		    			System.out.println("Withdraw successful\n Available Amount is :"+bal);
		    		}
		    			
		    	}
		    	case 3->
		    	{
		    		System.out.println("enter current password");
		    		int curpwd=bs.nextInt();
		    		System.out.println("enter new password");
		    		int newpwd=bs.nextInt();
		    		
		    		
		    		
		    		int status=dao.changepwd(curpwd, newpwd, res);
		    		if(status==1)
		    		{
		    			System.out.println("password changed.....");
		    		}
		    		else 
		    		{
		    			System.out.println("something went wrong");
		    		}
		    	}
		    	case 4->
		    	{
		    		System.out.println("enter password for confirmation");
		    		int passwrd=bs.nextInt();
		    		
		    		int status=dao.delaccount(passwrd, res);
		    		if(status==1)
		    		{
		    			System.out.println("your account is deleted");
		    		}
		    		else
		    		{
		    			System.out.println("something went wrong");
		    		}
		    	}
		  
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		   }
		    	
		    }
			
		}
		
  }
		
		bs.close();
	}
}
