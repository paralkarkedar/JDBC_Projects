package com.ihub.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class TXNManagementApp 
{
	public static void main(String[] args)throws Exception  
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the source account number : ");
		int sno=sc.nextInt();
		
		System.out.println("Enter the destination account number :");
		int dno=sc.nextInt();
		
		System.out.println("Enter the amount to transfer :");
		int amt=sc.nextInt();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		
		//set auto commit false
		con.setAutoCommit(false);
		
		Statement st=con.createStatement();
		
		//Declare the queries
		String qry1="update sbi set accbal=accbal-"+amt+" where accno="+sno;
		String qry2="update kotak set accbal=accbal+"+amt+" where accno="+dno;
		
		//add each query to batch
		st.addBatch(qry1);
		st.addBatch(qry2);
		
		//execute the batch
		int[] arr=st.executeBatch();
		
		boolean flag=true;
		for(int i:arr)
		{
			if(i==0)
			{
				flag=false;
				break;
			}
		}
		
		if(flag==true)
		{
			System.out.println("Transaction done Successfully");
			con.commit();
		}
		else
		{
			System.out.println("Transaction Failed");
			con.rollback();
		}
		
		st.close();
		con.close();
		
	}
}