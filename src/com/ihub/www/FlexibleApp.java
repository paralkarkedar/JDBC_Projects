package com.ihub.www;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class FlexibleApp 
{
	public static void main(String[] args)throws Exception  
	{
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		String qry="select * from student";
		ResultSet rs=st.executeQuery(qry);
		while(rs.next())
		{
			System.out.println(rs.getRow()+" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		
		rs.close();
		st.close();
		con.close();
	}
}