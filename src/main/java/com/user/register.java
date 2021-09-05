package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.adUser;
import com.admin.connectSql;

@WebServlet("/register")
public class register extends HttpServlet 

{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		try 
		{

			// retrieving input data from (adModerator.jsp).........
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String firstname = request.getParameter("userFirstName");
			String lastname = request.getParameter("userLastName");
			String email = request.getParameter("userEmail");
			String Password = request.getParameter("userPassword");
			String FinalPassword = request.getParameter("userFinalPassword");
			String date = new Date().toString();
			
			//connection creation 
			Connection con = connectSql.getConnection();
			
			//query for checking the user whether the user is blocked or not
			String q="select * from blocked_user";
			Statement st = con.createStatement();
			ResultSet set = st.executeQuery(q);
			
			boolean blocked=false;
			
			while (set.next()) 
			{
				String blockedEmail=set.getString("bEmail");
				if (blockedEmail.equals(email)) 
				{
				blocked=true;
				break;
				}
			}
            if (blocked) 
            {
				out.println("<h1> you have been blocked......");
			}
            else 
		  {
            	
            	boolean registered=false;
            	ResultSet set2=adUser.viewUser();
            	
            	while (set2.next()) 
              {  
				String regEmail=set2.getString("uEmail");
				if (regEmail.equals(email)) 
				{
					registered=true;
				out.println("<h1> you already registered try to login.........");	
				}
              }
				 
			if (registered==false) 
			{
				// this is for password match........
				if (Password.equals(FinalPassword)) 
				{
//					out.println(name);
//					out.println(email);
//					out.println(modPassword);
//					out.println(FinalPassword);
//					out.println(date);
//					
					
					// query created for register new user......
					String q2 = "insert into user(uFirstName,uLastName,uEmail,uPassword,uTime) value(?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(q2);

					ps.setString(1, firstname);
					ps.setString(2, lastname);
					ps.setString(3, email);
					ps.setString(4, Password);
					ps.setString(5, date);

					ps.executeUpdate();

					// connection checking for conform the connection......
					if (con.isClosed()) 
					{
						
						out.println("connection failed..");
						
					} 
					else 
					{
						
						// out.println("<h1>connection created..</h1>");
						out.println("<h1>You have registered successfully</h1>");
						
					}
				} 
				else 
				{
					
					// password mismatch condition..........
					out.println("<h2> Your password does not match");
					
				}
			}	
						
		 }
				
			
            	
				
		 
			

		}
		catch (Exception e) 
		{

			e.printStackTrace();
		}
	}
}
