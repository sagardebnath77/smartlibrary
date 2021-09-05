<%@page import="com.admin.adUser"%>
<%@page import="com.admin.adViewModerator"%>

<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.admin.adViewModerator"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin's User Page</title>
</head>
<body>

	<h1>:User:</h1>

	
	<br>
	<br>


	<!-- this section is used for showing the list of Users from (adUser.java)  -->
	<%!int id;
	String firstname,lastname, email,  date;%>

	<%
	ResultSet set = adUser.viewUser();
	while (set.next()) {

		id = set.getInt("uId");
		firstname = set.getString("uFirstName");
		lastname = set.getString("uLastName");
		email = set.getString("uEmail");
		date = set.getString("uTime");
	%>

	<%=id + " : " + firstname +" "+ lastname+" : " + email + ": Date of login :" + date%>


	<!-- this section is used for send the fetched data to (adBlockUser.java) -->
	<%="<a href='adBlockUser?userEmail="+email+"' ><button >Block User</button></a>"%>
	<br>
	<br>
	<%
	}
	%>
</body>


</html>