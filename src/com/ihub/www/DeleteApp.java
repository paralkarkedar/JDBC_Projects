//Q) Write a jdbc application to delete student record based on student number?

package com.ihub.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteApp 
{
	public static void main(String[] args)throws Exception  
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the student no :");
		int no=sc.nextInt();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		Statement st=con.createStatement();
		
		String qry="delete from student where sno="+no;
		
		int result=st.executeUpdate(qry);
		
		if(result==0)
			System.out.println("No Record Deleted");
		else
			System.out.println(result+" Record Deleted");
		
		st.close();
		con.close();
	}
}



























