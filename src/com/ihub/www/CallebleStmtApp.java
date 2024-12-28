package com.ihub.www;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallebleStmtApp 
{
	public static void main(String[] args)throws Exception  
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		
		//create a Callable stmt object
		CallableStatement cst=con.prepareCall("{CALL first_proc(?,?,?)}");
		
		//register out parameter
		cst.registerOutParameter(3,Types.INTEGER);
		
		//set the values to IN parameter
		cst.setInt(1, 30);
		cst.setInt(2, 20);
		
		//execute 
		cst.execute();
		
		//gather the result
		int result=cst.getInt(3);
		
		System.out.println("sum of two numbers is ="+result);

		cst.close();
		con.close();
	}
}