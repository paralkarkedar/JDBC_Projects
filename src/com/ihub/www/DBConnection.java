package com.ihub.www;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
	static Connection con=null;
	
	private DBConnection()
	{
		
	}
	
	public static Connection getConnection()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			if(con==null)
			{
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
}