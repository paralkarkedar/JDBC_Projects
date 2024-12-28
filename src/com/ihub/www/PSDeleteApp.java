//Q) Write a JDBC application to delete student record based on student no?

package com.ihub.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PSDeleteApp 
{
	public static void main(String[] args)throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the student no :");
		int no=sc.nextInt();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
	
		String qry="delete from student where sno=?";
		
		PreparedStatement ps=con.prepareStatement(qry);
		
		//set the values
		ps.setInt(1, no);
		
		//execute 
		int result=ps.executeUpdate();
		
		if(result==0)
			System.out.println("No Record Deleted");
		else
			System.out.println("Record Deleted");
		
		ps.close();
		con.close();
	}
}
