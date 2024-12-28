package com.ihub.www;
// this program is used to understanding the sql injection problem
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SQLInjProbApp 
{
	public static void main(String[] args)throws Exception  
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the username :");
		String name=sc.next();
		
		System.out.println("Enter the password :");
		String pass=sc.next();
		
		//convert input values according to SQL query
		name="'"+name+"'";
		pass="'"+pass+"'";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		Statement st=con.createStatement();
		
		String qry="select count(*) from userlist where uname="+name+" and pwd="+pass;
		
		ResultSet rs=st.executeQuery(qry);
		
		int result=0;
		while(rs.next())
		{
			result=rs.getInt(1);
		}
		
		if(result==0)
			System.out.println("Invalid Credentials ");
		else
			System.out.println("Valid Credentials ");
		
		rs.close();
		st.close();
		con.close();
	}
}
