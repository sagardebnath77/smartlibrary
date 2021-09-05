package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class updateBookServlet extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String str = req.getParameter("btn");
		String book_Name = req.getParameter("vbook-name");
		String Author_Name = req.getParameter("vAuthor-name");
		String Edition_Name = req.getParameter("vEdition-name");
		String Publisher_Name = req.getParameter("vpublisher-name");
		String Category_Name = req.getParameter("vCategory");
		if (Category_Name == null) {
	     Category_Name = req.getParameter("vnew-category");
		}
		int book_id = Integer.parseInt(req.getParameter("vbook-id"));
		String b_location = req.getParameter("book-location");
		//converting all data into books object
		Books upBook = new Books(book_id,book_Name,Author_Name,Publisher_Name,Edition_Name,Category_Name);
		
		
		if (str.equals("updt")) {
			 upBook.updateBook(upBook);
		    
			
		}else if (str.equals("dlt")) {
			upBook.deleteBook(upBook,b_location);
			
			
		}
	}

}
