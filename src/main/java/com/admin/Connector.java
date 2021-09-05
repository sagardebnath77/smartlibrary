package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
// class to establish connection with database
public class Connector {
	public static Connection getConnect() {
		Connection con = null;
		try {   
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_library","root","987651234");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
		
	}
}
