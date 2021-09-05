package com.admin;

import java.io.File;
import java.sql.*;
import java.util.*;

public class Books {
	
	private int bId;
	private String bName;
    private String authorName;
    private String publisherName;
    private String edition;
    private String category;
    private String location;
    private Timestamp time;
    private Connection con;
    private boolean check;
    public Books() {
		// TODO Auto-generated constructor stub
	}
    
    
    public Books(Connection con) {
		this.con=con;
	}
    
    
   public Books(int bId, String bName, String authorName, String publisherName,String edition, String category, String location, Timestamp time) {
	   this.bId=bId;
	   this.bName=bName;
	   this.authorName=authorName;
	   this.publisherName=publisherName;
	   this.edition=edition;
	   this.category=category;
	   this.location=location;
	   this.time = time;
	   
   }
   
   
   public Books(String bName, String authorName, String publisherName,String edition, String category, String location) {
	   this.bName=bName;
	   this.authorName=authorName;
	   this.publisherName=publisherName;
	   this.edition=edition;
	   this.category=category;
	   this.location=location;
	   
   }
   
   
   public Books(int bId,String bName, String authorName, String publisherName,String edition, String category) {
	   this.bId=bId;
	   this.bName=bName;
	   this.authorName=authorName;
	   this.publisherName=publisherName;
	   this.edition=edition;
	   this.category=category;
	   
   }
   
   
   public int getbId() {
	return bId;
}
   public String getbName() {
	return bName;
}
   public String getAuthorName() {
	return authorName;
}
   public String getPublisherName() {
	return publisherName;
}
   public String getEdition() {
	return edition;
}
   public String getCategory() {
	return category;
}
   public String getLocation() {
	return location;
} 
   public Timestamp getTime() {
	return time;
}
   
   
   //function to get all categories
   
   public ArrayList<String> getAllCategory() {
	   ArrayList<String> list= new ArrayList<String>();
	   try {
		 String q = "select category from books";
		 ResultSet rst = this.con.createStatement().executeQuery(q);
		 while (rst.next())
		 {
			 String cat = rst.getString("category");
			 if(!list.contains(cat))
			 {
			 list.add(cat);
			 }
		 }
		 
		 
	} catch (Exception e) {
		e.printStackTrace();
	}
	   
	   return list;

}
   
   
  // function to get all book list 
   
   public ArrayList<Books> getAllPosts() {
		   ArrayList<Books> list= new ArrayList<Books>();
		   try {
			 String q = "select * from books ORDER BY bId DESC";
			 ResultSet rst = this.con.createStatement().executeQuery(q);
			 while (rst.next())
			 {
				 int bookId= rst.getInt("bId");
				 String bookName = rst.getString("bName");
				 String author_Name = rst.getString("authorName");
				 String pubName = rst.getString("publisherName");
				 String edtionName = rst.getString("edition");
				 String catName = rst.getString("category");
				 String locationName = rst.getString("location");
				 Timestamp dateTime = rst.getTimestamp("bTime");
				 
				 Books items = new Books(bookId,bookName,author_Name,pubName,edtionName,catName,locationName,dateTime);
				 list.add(items);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		   
		   return list;
   }
   
  
   //function to add book
   
   public boolean addBook(Books book) {
	    check = false;
	   
	   try {   
			Connection connect = Connector.getConnect(); // calling getConnect function from Connector class(user defined)
		String cmd= "insert into books(bName, authorName, publisherName, edition, category, location) values(?,?,?,?,?,?)";
		PreparedStatement preSmt= connect.prepareStatement(cmd);
		preSmt.setString(1,book.getbName());
		preSmt.setString(2,book.getAuthorName());
		preSmt.setString(3,book.getPublisherName());
		preSmt.setString(4,book.getEdition());
		preSmt.setString(5,book.getCategory());
		preSmt.setString(6,book.getLocation());
		
		preSmt.executeUpdate();
		
		check = true;
		
		}catch (Exception e)
		{
			e.printStackTrace();
			
		}
	   return check;
	   
	
}
   
  
 //function to update book
   
   public boolean updateBook(Books book) {
	    check = false;
	   try {   
			Connection connect = Connector.getConnect(); // calling getConnect function from Connector class(user defined)
		//int n=book.getbId();
		String cmd= "UPDATE books SET bName=?, authorName=?, publisherName=?, edition=?, category=? WHERE bId=?";
		PreparedStatement preSmt= connect.prepareStatement(cmd);
		preSmt.setString(1,book.getbName());
		preSmt.setString(2,book.getAuthorName());
		preSmt.setString(3,book.getPublisherName());
		preSmt.setString(4,book.getEdition());
		preSmt.setString(5,book.getCategory());
		preSmt.setInt(6,book.getbId());
		preSmt.executeUpdate();
		
		
		check = true;
		
		
		}catch (Exception e)
		{
			e.printStackTrace();
			
		}
	   return check;
	   
	
}
   
   //function to delete book
   
   public boolean deleteBook(Books book,String filePath) {
	    check = false;
	   try {   
			Connection connect = Connector.getConnect(); // calling getConnect function from Connector class(user defined)
		
		String cmd= "DELETE FROM books WHERE bId=?";
		PreparedStatement preSmt= connect.prepareStatement(cmd);
		preSmt.setInt(1,book.getbId());
		preSmt.executeUpdate();
		File file = new File(filePath);
		   check=file.delete();
		
		check = true;
		
		
		}catch (Exception e)
		{
			e.printStackTrace();
			
		}
	   return check;
	   
	
}
	   
   
   //function to find book by book id
   
   public Books getBookById(String id) {
	   Books item=new Books();
	   try {
		     
			 String q = "select * from books WHERE bId="+id;
			 ResultSet rst = this.con.createStatement().executeQuery(q);
			 while (rst.next())
			 {
				 int bookId= rst.getInt("bId");
				 String bookName = rst.getString("bName");
				 String author_Name = rst.getString("authorName");
				 String pubName = rst.getString("publisherName");
				 String edtionName = rst.getString("edition");
				 String catName = rst.getString("category");
				 String locationName = rst.getString("location");
				 Timestamp dateTime = rst.getTimestamp("bTime");
				 
				  item = new Books(bookId,bookName,author_Name,pubName,edtionName,catName,locationName,dateTime);
				 
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		   
		   return item;

   }
}
