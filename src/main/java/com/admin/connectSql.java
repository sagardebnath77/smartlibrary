package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;

//this class is only used for creating the connection .........
// it returns the connection .........
public  class connectSql 
{
     public static Connection con;
	public static Connection getConnection() 
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 String url="jdbc:mysql://localhost:3306/smart_library";
			 String username="root";
			 String password="1234";
			  con=DriverManager.getConnection(url,username,password);
			 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		return con;
	}
	
}
