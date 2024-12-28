package com.ihub.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateInsertApp 
{
	public static void main(String[] args)throws Exception  
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the employee id :");
		int no=sc.nextInt();
		
		System.out.println("Enter the employee name :");
		String name=sc.next();
		
		System.out.println("Enter the DOJ (dd-MM-yyyy) :");
		String sdoj=sc.next();
		
		//convert string date to util date
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udoj=sdf.parse(sdoj);
		
		//converting util date to sql date 
		long ms=udoj.getTime();
		java.sql.Date sqldoj=new java.sql.Date(ms);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		
		String qry="insert into emp1 values(?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(qry);
		
		//set the values 
		ps.setInt(1, no);
		ps.setString(2, name);
		ps.setDate(3, sqldoj);
		
		
		//execute 
		int result=ps.executeUpdate();
		
		if(result==0)
			System.out.println("No Record Inserted");
		else
			System.out.println("Record Inserted");
			
		ps.close();
		con.close();
	}
}
