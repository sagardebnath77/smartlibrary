package com.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//this class is used for fetch moderator's data from (smart_library) database.........
//it returns the resultset's object to (adModerator.jsp)......... 
public class adViewModerator {

	public static ResultSet set;

	public static ResultSet view() throws SQLException {
		Connection con = connectSql.getConnection();

		String q = "select * from moderator";
		Statement st = con.createStatement();

		ResultSet set = st.executeQuery(q);

		return set;
	}

}
