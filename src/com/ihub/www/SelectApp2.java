package com.ihub.www;
//Q) Write a jdbc application to select student name and student address based on student number?
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectApp2 {
public static void main(String[] args)throws Exception {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the student no : ");
	int no = sc.nextInt();
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
	Statement st=con.createStatement();
	
	String qry="select sname,sadd from student where sno="+no;
	
	ResultSet rs=st.executeQuery(qry);
	while(rs.next())
	{
		System.out.println(rs.getString(1)+" "+rs.getString(2));
	}
	
	rs.close();
	st.close();
	con.close();
  }
}
