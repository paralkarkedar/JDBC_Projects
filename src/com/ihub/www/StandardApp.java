/*Standard Procedure To Write JDBC Application
=============================================
*/
package com.ihub.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StandardApp 
{
	public static void main(String[] args) 
	{
		final String DRIVER="oracle.jdbc.driver.OracleDriver";
		final String URL="jdbc:oracle:thin:@localhost:1521:XE";
		final String USERNAME="system";
		final String PASSWORD="admin";
		final String QUERY="select * from student";
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			st=con.createStatement();
			rs=st.executeQuery(QUERY);
			while(rs.next())
			{
				System.out.println(rs.getRow()+" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}