//Q) Write a jdbc application to update student name based on student number?
package com.ihub.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateApp 
{
	public static void main(String[] args)throws Exception  
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the student no :");
		int no=sc.nextInt();
		
		System.out.println("Enter the student name :");
		String name=sc.next();
	
		
		//converting input values according to SQL query
		name="'"+name+"'";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		Statement st=con.createStatement();
		
		String qry="update student set sname="+name+" where sno="+no;
		
		int result=st.executeUpdate(qry);
		if(result==0)
			System.out.println("No Record Updated");
		else
			System.out.println(result+" Record Updated");
		
		st.close();
		con.close();
	}
}
