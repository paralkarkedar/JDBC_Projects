// Write a JDBC application to update student name based on student number?

package com.ihub.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PSUpdateApp 
{
	public static void main(String[] args)throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the student no:");
		int no=sc.nextInt();
		
		System.out.println("Enter the student name :");
		String name=sc.next();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		
		String qry="update student set sname=? where sno=?";
		
		PreparedStatement ps=con.prepareStatement(qry);
		
		//set the values
		ps.setString(1,name);
		ps.setInt(2, no);
		
		//execute
		int result=ps.executeUpdate();
		
		if(result==0)
			System.out.println("No Record Updated");
		else
			System.out.println("Record Updated");
		
		ps.close();
		con.close();
	}
}

