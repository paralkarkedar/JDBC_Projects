package com.ihub.www;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PhotoRetrieveApp 
{
	public static void main(String[] args)throws Exception  
	{

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		Statement st=con.createStatement();	
		String qry="select * from emp2";
		ResultSet rs=st.executeQuery(qry);
		while(rs.next())
		{
			InputStream is = rs.getBinaryStream(3);
			
			FileOutputStream fos=new FileOutputStream("D:\\navneeth.png");
			
			int byteReads=0;
			byte[] buffer=new byte[250];
			
			while((byteReads=is.read(buffer))!=-1)
			{
				fos.write(buffer,0, byteReads);
			}
			fos.close();
		}
		System.out.println("Please check the location");
		rs.close();
		st.close();
		con.close();
	}
}