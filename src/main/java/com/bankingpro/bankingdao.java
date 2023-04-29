package com.bankingpro;
import java.sql.*;
//controler which is communicating with bs;

public class bankingdao {

	Connection con=null;
	//method to get connection to db
	public void dbconnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingpro","root","Bindu@123");	
	}
	
	//method to register customer details and store in db
	public int registercustomer(customer c1) throws Exception {
		String query="insert into customer values(?,?,?,?)";
		
		PreparedStatement pst=con.prepareStatement(query);
		
		pst.setInt(1,c1.cusid);
		pst.setString(2,c1.cusname);
		pst.setInt(3,c1.cuspin);
		pst.setInt(4,c1.cusamount);
		
		int res=pst.executeUpdate();
		return res;
	}
	
	public int login(String uname,int pwd) throws Exception
	{
		//fetching the user details based on username
		String query="select * from customer where cusname= '"+uname+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		//checking whether we  have user details or not
		if(rs.next())
		{
			//fetching the password from db
			int password=rs.getInt(3);
			//matching the password
			if(pwd==password)
			{
				//login success
				return rs.getInt(1);
			}
			else 
			{
				//wrong password
				return 0;
			}
			
		}
		else 
		{
			//unable to fetch user details
			return -1;
		}		
	}
	
	public int deposit(int amount,int customerid) throws Exception
	{
		//fetching user details based on customer id
		String query="select * from customer where cusid="+customerid;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		rs.next();
		//extracting account balance
		int bal=rs.getInt(4);
		//updating amount
		amount+=bal;
		

		//storing the updated amount
		String query2="update customer set cusamount="+amount+" where cusid="+customerid;
		PreparedStatement pst=con.prepareStatement(query2);
		
		pst.executeUpdate();
		//returning updated amount
		 return amount;
	}
	
	public int withdraw(int amount,int cnfmpwd, int customerid) throws Exception
	{
		//fetching user details based on customer id
		String query="select * from customer where cusid="+customerid;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		rs.next();//calling next to fetch data from rs
		int availamt=rs.getInt(4);//extracting available amount
		
		if(cnfmpwd==rs.getInt(3))
		{
			//if available amount is > required amount  only  then  withdraw
			if(amount<=availamt)
			{
				availamt-=amount;
				String query2="update  customer set cusamount="+amount+" where cusid="+customerid;
				PreparedStatement pst=con.prepareStatement(query2);//sending query with statement
				pst.executeUpdate();
				return availamt;	
			}
			else
			{
				return 0;
			}
		}
		else {
			return -1;
		}
		
		
	}
	public int changepwd(int currentpwd,int newpwd,int customerid) throws Exception
	{
		//fetching user details
		String query="select * from customer where cusid="+customerid;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		rs.next();
		
		
		//confirming existing password
		if(currentpwd==rs.getInt(3))
		{
			//update new pwd in db
			String query2="update customer set cuspin="+newpwd+" where cusid="+customerid;
			PreparedStatement pst=con.prepareStatement(query2);
			pst.executeUpdate();
			return 1;
		}
		else
		{
			return 0;
		}
		
		
	}
	public int delaccount(int confpwd, int customerid) throws Exception
	{
		//fetching user details
		String query="select * from customer where cusid="+customerid;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		rs.next();
		//confirming pwd
		if(confpwd==rs.getInt(3))
		{
			//delete the account
			String query2="delete from customer where cusid="+customerid;
			PreparedStatement pst=con.prepareStatement(query2);
			pst.executeUpdate();
			return 1;
			
		}
		else
		{
			return 0;
		}
	}
}
