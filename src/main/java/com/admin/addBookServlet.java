package com.admin;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@MultipartConfig 
public class addBookServlet extends HttpServlet {

	public void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException {
		rs.setContentType("text/html");
		PrintWriter out = rs.getWriter();
		String book_name = rq.getParameter("book-name");
		String Author_name = rq.getParameter("Author-name");
		String Edition_name = rq.getParameter("Edition-name");
		String publisher_name = rq.getParameter("publisher-name");
		String Category = rq.getParameter("Category");
		if (Category==null) {
			Category = rq.getParameter("new-Category");
		}
		Part filePart=rq.getPart("fileInput");
		InputStream fileInpt=filePart.getInputStream(); //fetch the pdf
		byte [] data= new byte[fileInpt.available()]; // read the data of pdf
		fileInpt.read(data); // write the data of pdf
		String filePath = getServletContext().getRealPath(File.separator+"media"+File.separator+Author_name+" - "+book_name);
		FileOutputStream fileOutput = new FileOutputStream(filePath); // load the file path
		fileOutput.write(data); // write pdf file in file path
		fileOutput.close();
		
        //Connection..
		Books insertBook = new Books(book_name,Author_name,Edition_name,publisher_name,Category,filePath);
		if(insertBook.addBook(insertBook) == true)
		{
			out.println("done...");
		}
		
	}

}