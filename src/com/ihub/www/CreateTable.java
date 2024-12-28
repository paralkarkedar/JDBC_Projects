package com.ihub.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateTable {
    public static void main(String[] args) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
        
        String qry = "CREATE TABLE student21(id NUMBER(10), first_name VARCHAR2(50),last_name VARCHAR2(50),email VARCHAR2(100),age NUMBER(10))";
        
        PreparedStatement ps = con.prepareStatement(qry);
        
        ps.executeUpdate();
        
        System.out.println("Table 'student2' created successfully.");
        
        ps.close();
        con.close();
    }
}
