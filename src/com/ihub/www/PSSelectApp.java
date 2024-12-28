//Q) Write a JDBC application to select student records using PrepareStatement object?

package com.ihub.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PSSelectApp 
{
	public static void main(String[] args)throws Exception  
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		String qry="select * from student";
		PreparedStatement ps=con.prepareStatement(qry);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		rs.close();
		ps.close();
		con.close();
	}
}