package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/adEditModerator")

//this class is used for edit(update&delete) the saved moderator.........
public class adEditModerator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("moderatorId"));
		String firstname=request.getParameter("moderatorFirstName");
		String lastname=request.getParameter("moderatorLastName");
		String email=request.getParameter("moderatorEmail");
		String password=request.getParameter("moderatorPassword");
		String action=request.getParameter("action");
		
		
		try 
		{
			
		//connection......	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_library","root","1234");
			
			if (action.equals("update")) 
			{
				
				//creating quary for update the moderator........
				String q1="update moderator set mFirstName=?,mLastName=?, mEmail=?, mPassword=? where mId=?";
				PreparedStatement ps=con.prepareStatement(q1);
				ps.setString(1, firstname);
				ps.setString(2, lastname);
				ps.setString(3, email);
				ps.setString(4, password);
				ps.setInt(5, id);
				 
				ps.executeUpdate();
				out.println("Moderator Updated");
			} 
			 else  
			{
				
			//creating the quary for delete the moderator.......
				 String q2="delete from moderator where mId=?";
				 PreparedStatement ps2=con.prepareStatement(q2);
				 ps2.setInt(1, id);
				 
				 ps2.executeUpdate();
				 out.println("Moderator Deleted");
			}
			
			
			
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
	}

}
