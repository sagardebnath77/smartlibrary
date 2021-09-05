<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User login page</title>
</head>
<body>
	<form action="login" method="POST">

		<h1 class="log">Log In Now</h1>
		<div class="login">
			<div class="group">
				<label for="user" class="label">Email-id</label> <input id="user"
					type="email" name="userEmail" class="input" placeholder="Enter your email">
			</div>
			<div class="group">
				<label for="pass" class="label">Password</label> <input id="pass"
					type="password" name="userPassword" class="input" data-type="password"
					placeholder="Enter your password">
			</div>
			<div class="group">
				<input type="submit" class="button" value="Sign In">
			</div>
			<div class="hr"></div>
		</div>
		<h4>New Member Here?</h4>


	</form>
	<a href="register.jsp">
		<button>Register</button>
	</a>







</body>
</html>