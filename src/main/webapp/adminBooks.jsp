<%@page import="com.admin.Connector"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.admin.Books"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Books</title>
</head>


<body>
    <section id="add-book">
        <form action="bookServlet" name="" id="add-book-form" method="post" enctype="multipart/form-data">
            <h3>Enter name</h3>
            <input type="text" name="book-name" id="" placeholder="Enter book name.." />
            <h3>Enter Author Name</h3>
            <input type="text" name="Author-name" id="" placeholder="Enter author name.." />
            <h3>Enter edition</h3>
            <input type="text" name="Edition-name" id="" placeholder="Enter Edition.." />
            <h3>Enter publisher</h3>
            <input type="text" name="publisher-name" id="" placeholder="Enter publisher name.." />
            <h3>Enter category</h3>
            <input type="text" name="Category" id="selectCat" placeholder="Enter Category name.." disabled onclick="disableFun2()"
            ondblclick="disableFun()"/>

            <p>Choose an exsisting category:</p>
            <select name="new-Category" id="selectOpt" onclick="disableFun()"
            ondblclick="disableFun2()">
            
            <!--choose from existing category-->
            
                <option value="optStart" disabled selected>--Select Option--</option>
                <% 
                 Connection con = Connector.getConnect();
                Books bk = new Books(con);
                 ArrayList<String> list= bk.getAllCategory();
                 for (String str:list)
                 {
                %>
                <option value=<%= str %>><%= str %></option>
      			<%
                 }
      			%>
            </select>
            

            <input type="file" accept=".pdf" name="fileInput">
            <button type="submit">Add</button>
        </form>
    </section>
    <section id="show-book">
        <div id="book-list">
        
        <!-- Display all books list -->
        
        <%
         ArrayList<Books> bookList=bk.getAllPosts();
        for (Books bklst : bookList)
        {
        %>

            <div id="number"><%= bklst.getbId() %></div>
            <div id="xyz"><%= bklst.getTime() %></div>
            <div id="book"><h3><%= bklst.getbName() %></h3></div>
            <div id="author"><p><%= bklst.getAuthorName() %></p></div>
            <div id="edition"><p><%= bklst.getEdition() %></p></div>
            <div id="publication" ><p><%= bklst.getPublisherName() %></p></div>
            <div id="viewanddelete" ><a href="viewBook.jsp?id=<%= bklst.getbId() %>">view</a></div>
         <%
        } 
         %>
        </div>
    </section>
    
    <!-- Javascript functions to enable and disable -->
    
    <script type="text/javascript">
    function disableFun() {
        document.getElementById("selectCat").setAttribute("disabled", "");
        document.getElementById("selectOpt").removeAttribute("disabled");
        document.getElementById("selectCat").value=null;

    }
    function disableFun2() {
    	document.getElementById("selectOpt").setAttribute("disabled", "");
    	document.getElementById("selectCat").removeAttribute("disabled");
        document.getElementById("selectOpt").value="optStart";
    }
    </script>
</body>

</html>