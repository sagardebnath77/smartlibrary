package com.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class adUser {
	
	
	public static ResultSet set;
	public static ResultSet viewUser()throws SQLException {
		
		
		Connection con=connectSql.getConnection();
		String q="select * from user";
		Statement st=con.createStatement();
		 set=st.executeQuery(q);
		
		 return set;
		
	}

}
