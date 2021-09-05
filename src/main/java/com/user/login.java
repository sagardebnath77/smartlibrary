package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.connectSql;

@WebServlet("/login")
public class login extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// this is for creating  connection
		Connection con = connectSql.getConnection();
		String email = request.getParameter("userEmail");
		String password = request.getParameter("userPassword");
		
		
		
		try 
		{
			//query for checking the user registered or not
			String q = "select * from user";
			Statement st = con.createStatement();
			ResultSet set = st.executeQuery(q);
			
			//query for checking the user whether the user is blocked or not
			String q1="select * from blocked_user";
			Statement st1 = con.createStatement();
			ResultSet set1 = st1.executeQuery(q1);
			
			boolean blocked=false;
			boolean register = false;
			
			while (set1.next()) 
			{
			
				String bEmail=set1.getString("bEmail");
				if (email.equals(bEmail)) 
				{
					blocked=true;
				   out.println("<h1> User who is registered in email ::"+email+":: has been blocked ");
				   break;
				}
				
			}
			
			if (blocked) 
			{
				 out.println("currently you are not able to access our library......");
			}
			else 
			{
				while (set.next()) 
				{

					String uEmail = set.getString("uEmail");
					String uPassword = set.getString("uPassword");
					String uFirstName = set.getString("uFirstName");
					String uLastName = set.getString("uLastName");

					// this line is used for checking the registered user.......
					if (email.equals(uEmail) && password.equals(uPassword)) 
					{

						out.println("<h1> welcome : " + uFirstName + "" + uLastName + "</h1>");
						register = true;

					}

				}
			

				if (register) 
				{

					out.println("<h1> you have successfully logged in........");

				} else 
				{
					
					out.println("<h1>you are a new user you have to register at first....... ");
					
				}
			}

			

		} catch (Exception e) 
		{

			e.printStackTrace();
		}

	}

}
