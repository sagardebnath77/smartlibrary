<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User register page</title>
</head>
<body>
	<form action="register" method="POST">
		<h1 class="heading">Register Your Account Now</h1>
		<div class="register-form">
			<div class="group">
			<span>
				<label for="user" class="label">Name</label> <input id="user"
					type="text" class="input" name="userFirstName" placeholder="Enter your Firstname">
			
			 
				<label for="user" class="label"></label> <input id="user"
					type="text" class="input" name="userLastName" placeholder="Enter your Lastname">
			</span>
			</div>
			<div class="group">
				<label for="pass" class="label">Email Address</label> <input
					id="pass" type="email" class="input"
					name="userEmail" placeholder="Enter your email address">
			</div>
			<div class="group">
				<label for="pass" class="label">Password</label> <input id="pass"
					type="password" class="input" data-type="password"
					name="userPassword" placeholder="Create your password">
			</div>
			<div class="group">
				<label for="pass" class="label">Re-enter Password</label> <input
					id="pass" type="password" class="input" data-type="password"
					name="userFinalPassword" placeholder="Repeat your password">
			</div>

			<div class="group">
				<input type="submit" class="button" value="Register">
			</div>
			<div class="hr"></div>


		</div>


		<br> <br>
		<button type="button" class="button" name="skip">

			<span class ="button__text" name="skip">Skip For Now</span>
			<span class ="button__icon"> 
			<ion-icon	name="play-skip-forward-circle-outline"></ion-icon> </span>
		</button>
		<script type="module"
			src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
		<script nomodule
			src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

	</form>
	<div class="foot">
		<label for="tab-1">Already Member?</label>
	</div>
	<div>
		<a href="login.jsp"><button>login</button></a>
	</div>

</body>
</html>