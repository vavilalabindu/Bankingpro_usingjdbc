package com.bankingpro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest 
   
{
    bankingdao b1=new bankingdao();
    
//    @Test
//    //positive test case
//    public void logintest() throws Exception
//    {
//    	b1.dbconnection();
//      	int exp=9950;
//      	int res=b1.login("ramya",1718);//res is actual value from db
//      	assertEquals(exp,res);
//      	
//    }
//     
//    @Test
//    //negative test case  (wrong password)
//    public void logintest2() throws Exception
//    {
//    	b1.dbconnection();
//      	int exp=9950;
//      	int res=b1.login("ramya",1719);//res is actual value from db
//      	assertEquals(exp,res);
//      	
//    }
//    
//    @Test
//    //negative test case  (incorrect username)
//    public void logintest3() throws Exception
//    {
//    	b1.dbconnection();
//      	int exp=9950;
//      	int res=b1.login("ram",1718);//res is actual value from db
//      	assertEquals(exp,res);
//      
//    }
//    
//    @Test
//    public void deptest() throws Exception
//    {
//    	b1.dbconnection();
//    	int exp=2000;
//    	int res=b1.deposit(500,9950);//res is actual value from db
//    	assertEquals(exp,res);
//    	
//    }
//
//    @Test
    //positive withdrawtestcase
//    public void testwithdraw() throws Exception
//     {
//    	
//    	b1.dbconnection();
//    	int exp=50;
//    	int res=b1.withdraw(50, 1200, 9950);
//    	assertEquals(exp,res);
//      }
    
//    @Test
//    //negative withdrawtestcase (if reqamt is greater than availamt)
//    public void testwithdraw2() throws Exception
//     {
//    	
//    	b1.dbconnection();
//    	int exp=0;
//    	int res=b1.withdraw(300000, 1718, 9950);
//    	assertEquals(exp,res);
//      }
//    
//    
//    @Test
//    public void testchgpwd() throws Exception
//    {
//    	
//    	b1.dbconnection();
//    	
//    	int exp=1;
//    	int res=b1.changepwd(4200,1200,9950);
//    	assertEquals(exp,res);
//    }
    
//    @Test
//  public void testchgpwd2() throws Exception
//  {
//  	
//  	b1.dbconnection();
//  	
//  	int exp=0;
//  	int res=b1.changepwd(5200,1200,9950);
//  	assertEquals(exp,res);
//  }
//   
//    @Test
//    public void testregister() throws Exception
//    {
//    	
//    	customer cu1=new customer();
//    	cu1.cusid=103;
//    	cu1.cusname="srilu";
//    	cu1.cuspin=4200;
//    	cu1.cusamount=8000;
//    	
//    	b1.dbconnection();
//    	int exp=1;
//    	
//    	int res=b1.registercustomer(cu1);
//    	assertEquals(exp,res);
//    	
//    }
    
    @Test
	public void testdel() throws Exception {
		b1.dbconnection();
		
		int exp=1;
		int act=b1.delaccount(4200, 103);
		assertEquals(exp,act);
	}
    
    
    
}

