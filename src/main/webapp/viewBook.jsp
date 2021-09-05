<%@page import="java.io.File"%>
<%@page errorPage="eroor.jsp" %>
<%@page import="com.admin.Connector"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.admin.Books"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View book</title>
</head>
<body>
<!-- fetching the pdf by its id -->
<%
Connection con = Connector.getConnect();
Books b = new Books(con);
String id=request.getParameter("id");
Books book=b.getBookById(id);
String pdfUrl = "./"+"media"+"/"+book.getAuthorName()+" - "+book.getbName()+".pdf";
%>
    <section id="add-book">
        <form action="updatebook" name="" id="add-book-form" method="post" >
            <h3>Enter name</h3>
            <input type="text" name="vbook-name" id="" placeholder="Enter book name.." value="<%= book.getbName() %>" />
            <h3>Enter Author Name</h3>
            <input type="text" name="vAuthor-name" id="" placeholder="Enter author name.." value="<%= book.getAuthorName() %>"/>
            <h3>Enter edition</h3>
            <input type="text" name="vEdition-name" id="" placeholder="Enter Edition.." value="<%= book.getEdition() %>" />
            <h3>Enter publisher</h3>
            <input type="text" name="vpublisher-name" id="" placeholder="Enter publisher name.." value="<%= book.getPublisherName() %>" />
            <h3>Enter category</h3>
            <input type="text" name="vCategory" id="selectCat" placeholder="Enter Category name.."
                 ondblclick="disableFun()" value="<%=book.getCategory()%>"/>
            <input type="hidden" name="vbook-id" value="<%=book.getbId() %>"/>
			<input type="hidden" name="book-location" value="<%=book.getLocation()%>">
            <p>Choose an exsisting category:</p>
            <select name="vnew-category" id="selectOpt"  ondblclick="disableFun2()" disabled>
                <option value="optStart" disabled selected>--Select Option--</option>
                <% 
                ArrayList<String> list= b.getAllCategory();
                 for (String str:list)
                 {
                %>
                <option value=<%= str %>><%= str %></option>
      			<%
                 }
      			%>
             </select>
            </br>
            </br>
           <button type="submit" value="updt" name="btn">Update</button>
            <button type="submit" value="dlt" name="btn">Delete</button>
            </form>
    </section>
    <section id="pdf-view-section">
    	<div id="header" class="header-top">

        <button id="prev-btn" class="btn">Previous Page</button>
        <span id="page-info">
            page <input type="text" id="page-num" readonly /> of <input type="text" id="total-num" readonly />
        </span>
        <button id="next-btn" class="btn">Next Page</button>

        jump to <input type="text" id="jumPage"/>
        <button id="jump-btn">go</button>
    </div>

    <div id="view-body" class="view-body">
        <canvas id="pdf-view" class="pdf-viewer"></canvas>
    </div>
      	
    </section>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/pdf.js/2.9.359/pdf.js"
        integrity="sha512-or6dZINrKDVWLBVCUIVHNwEf0qJtwBWvw9Edd/s2QCZYBl9lJgQZZqNQY2ZOWW8tF5Yoq6I8adPpC9ELlY325w=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script>
        //sending pdf file location to js 
         urlP = "<%=pdfUrl%>";
        
        </script>
    <script src="./js/script.js"></script>
 
    <script>

        function disableFun() {
            document.getElementById("selectCat").setAttribute("disabled", "");
            document.getElementById("selectOpt").removeAttribute("disabled");
            document.getElementById("selectCat").value = "";

        }
        function disableFun2() {
            document.getElementById("selectOpt").setAttribute("disabled", "");
            document.getElementById("selectCat").removeAttribute("disabled");
            document.getElementById("selectOpt").value = "optStart";
        }
    </script>
</body>
</html>