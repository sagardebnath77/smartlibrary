<%@page import="com.admin.adViewModerator"%>

<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.admin.adViewModerator"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin's Moderator Page</title>
</head>
<body>

	<h1>:Moderator:</h1>

	<form action="adModeratorServlet" method="POST">


		<div>
			First Name : <input type="text" name="moderatorFirstName"
				placeholder="Enter first name">
		</div>

		<div>
			Last Name : <input type="text" name="moderatorLastName"
				placeholder="Enter last name">
		</div>

		<div>
			Email : <input type="email" name="moderatorEmail"
				placeholder="Enter email id">
		</div>

		<div>
			Create Password : <input type="password" name="moderatorPassword"
				placeholder="Enter your passoword">
		</div>

		<div>
			Re-enter Password : <input type="password"
				name="moderatorFinalPassword" placeholder="Re-Enter your passoword">
		</div>

		<div>
			<button type="submit" value="addNewModerator">Add New
				Moderator</button>
		</div>

	</form>

	<br>
	<br>


	<!-- this section is used for showing the list of moderators from (adViewModerator.java)  -->
	<%!int id;
	String firstname,lastname, email, password, date;%>

	<%
	ResultSet set = adViewModerator.view();
	while (set.next()) {

		id = set.getInt("mId");
		firstname = set.getString("mFirstName");
		lastname = set.getString("mLastName");
		email = set.getString("mEmail");
		password = set.getString("mPassword");
		date = set.getString("mTime");
	%>

	<%=id + " : " + firstname +" "+ lastname+" : " + email + ": Date of admit :" + date%>


	<!-- this section is used for send the fetched data to (adEditModerator.jsp) -->
	<%="<a href='adEditModerator.jsp?moderatorFirstName=" + firstname +"&moderatorLastName="+lastname+"&moderatorId=" + id + "&moderatorEmail=" + email
		+ "&moderatorPassword=" + password + "'><button>Edit</button></a>"%>
	<br>
	<br>
	<%
	}
	%>
</body>


</html>