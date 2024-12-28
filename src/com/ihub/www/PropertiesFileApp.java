package com.ihub.www;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class PropertiesFileApp 
{
	public static void main(String[] args)throws Exception 
	{
		 //file and locate properties file
		FileInputStream fis=new FileInputStream("src/com/ihub/www/dbdetails.properties");
		
		//create a Properties class object
		Properties p=new Properties();
		
		//load the data from properties file to properties class.
		p.load(fis);
		
		//gather the data from properties class.
		String s1=p.getProperty("driver");
		String s2=p.getProperty("url");
		String s3=p.getProperty("username");
		String s4=p.getProperty("password");
		
		Class.forName(s1);
		Connection con=DriverManager.getConnection(s2,s3,s4);
		Statement st=con.createStatement();
		String qry="select * from student";
		ResultSet rs=st.executeQuery(qry);
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		rs.close();
		st.close();
		con.close();
	}
}