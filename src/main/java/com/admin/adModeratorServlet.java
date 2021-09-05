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
import java.util.Date;

@WebServlet("/adModeratorServlet")
public class adModeratorServlet extends HttpServlet {
	public static final long serialVersionUID = 1L;
       
	   String firstname,lastname,email,modPassword,FinalPassword,date; 
		    


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 try 
		   {
			 
				
			 //retrieving  input data  from (adModerator.jsp).........
			 response.setContentType("text/html");  
			 PrintWriter out=response.getWriter();
			 
			 
			     firstname=request.getParameter("moderatorFirstName"); 
			     lastname=request.getParameter("moderatorLastName"); 
				 email=request.getParameter("moderatorEmail"); 
				 modPassword=request.getParameter("moderatorPassword"); 
				 FinalPassword=request.getParameter("moderatorFinalPassword"); 
			     date=new Date().toString();
			     
			     
			    // this is for password match........ 
			if (modPassword.equals(FinalPassword)) 
			{
//				out.println(name);
//				out.println(email);
//				out.println(modPassword);
//				out.println(FinalPassword);
//				out.println(date);
//				
				   // connection creation.......
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				 String url="jdbc:mysql://localhost:3306/smart_library";
				 String username="root";
				 String password="1234";
				 Connection con=DriverManager.getConnection(url,username,password);
				 
				 //quary created for adding a new moderator......
				 String q="insert into moderator(mFirstName,mLastName,mEmail,mPassword,mTime) value(?,?,?,?,?)";
				 PreparedStatement ps=con.prepareStatement(q);
				 
				 
		 
				 ps.setString(1,firstname);
				 ps.setString(2,lastname);
				 ps.setString(3,email);
				 ps.setString(4,modPassword);
				 ps.setString(5, date);
				 
				 ps.executeUpdate();
				 
				 //connection checking for conform the connection......
				 if (con.isClosed()) 
				 {
					out.println("connection failed..");
				 } 
				 else 
				 {
			          //out.println("<h1>connection created..</h1>");
			          out.println("<h1>MOderator added successfully</h1>");
				 }
			} 
			else 
			{
				//password mismatch condition..........
         out.println("<h2> Your password does not match");
			}
			
		   } 
		   catch (Exception e) 
		   {
			
			e.printStackTrace();
		   }
	}

}
