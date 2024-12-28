package com.ihub.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class DateRetrieveApp 
{
	public static void main(String[] args)throws Exception  
	{

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		Statement st=con.createStatement();
		String qry="select * from emp1";
		ResultSet rs=st.executeQuery(qry);
		while(rs.next())
		{
			int no=rs.getInt(1);
			String name=rs.getString(2);
			java.sql.Date sqldoj=rs.getDate(3);
			
			//convert sql date to util date 
			java.util.Date udoj=(java.util.Date)sqldoj;
			
			//convert util date to string date 
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			String sdoj=sdf.format(udoj);
			
			System.out.println(no+" "+name+" "+sdoj);
		}
		
		rs.close();
		st.close();
		con.close();
		
	}
}
