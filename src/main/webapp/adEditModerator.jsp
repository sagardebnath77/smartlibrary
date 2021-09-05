<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Moderator Edit</title>
</head>
<body>

	<%!String id1, firstname,lastname, email, password;%>

	<%
	id1 = request.getParameter("moderatorId");
	firstname = request.getParameter("moderatorFirstName");
	lastname = request.getParameter("moderatorLastName");
	email = request.getParameter("moderatorEmail");
	password = request.getParameter("moderatorPassword");
	%>
	<div>
	<!-- this form submit to the (adEditModerator.java) -->
			
		<form action="adEditModerator" method="POST">


			<div>
				Enter the existing moderator ID :
				<%="<input type='text' name='moderatorId' value=" + id1 + ">"%>
			</div>
			<div>
				Enter the moderator First Name :
				<%="<input type='text' name='moderatorFirstName' value=" + firstname + ">"%>
			</div>
			<div>
				Enter the moderator Last Name :
				<%="<input type='text' name='moderatorLastName' value=" + lastname + ">"%>
			</div>
			<div>
				Enter the moderator Email :
				<%="<input type='text' name='moderatorEmail' value=" + email + ">"%>
			</div>
			<div>
				Enter the moderator Password :
				<%="<input type='text' name='moderatorPassword' value=" + password + ">"%>
			</div>
			<div>
				Choose The Action :
				<button type="submit" name="action" value="update">UPDATE</button>
			</div>
			<div>
				<button type="submit" name="action" value="delete">DELETE</button>
			</div>

			<!--	
				<button type="submit">Apply</button>
			 	UPDATE<input type="radio" name="action" value="update">
				DELETE<input type="radio" name="action" value="delete">
			 
			-->


		</form>
	</div>
</body>
</html>