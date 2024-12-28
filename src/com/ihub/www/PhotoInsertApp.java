package com.ihub.www;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PhotoInsertApp 
{
	public static void main(String[] args)throws Exception  
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the employee id : ");
		int id=sc.nextInt();
		
		System.out.println("Enter the employee name : ");
		String name=sc.next();
		
		//locate a file 
		File f=new File("src/com/ihub/www/rock.jpg");
		FileInputStream fis=new FileInputStream(f);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		
		String qry="insert into emp2 values(?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(qry);
		
		//set the values 
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setBinaryStream(3, fis,(int)f.length());
		
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