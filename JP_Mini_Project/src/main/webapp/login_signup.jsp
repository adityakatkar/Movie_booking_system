<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MovieBox</title>
<link rel="icon" type="image/x-icon" href="movie_logo_2.png">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Inter&family=Poppins:wght@400;500&display=swap" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/login_signup.css">
</head>

<body>

	<%
		
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setHeader("Expires","0"); //Proxies
	%>

	<div class="navigation">
		<a href="home.jsp"><img src="movie_logo.png" class="nav-img"/></a>
		<h1 class="nav-header">MovieBox</h1>
		<button class="nav-button"><a href="index.jsp">Home</a></button>
	</div>
	<div class="form">
		<div class="login-form">
			<h1 class="form-h1">Login Form</h1>
			<hr>
			<form action="Login" method="post">
			
				<input class = "input-text" type="text" placeholder="Name" name="username"  autocomplete="off">
				<br>
				<input class = "input-text" type="Password" placeholder="Password" name="password">
				<br>
				<input class = "input-btn" type="Submit" value="Login">
			</form>
			<h2 class="form-signup"><u> New User? Sign up</u></h2>
		</div>
		
		<div class="Signup-form">
			<h1 class="form-h1">Sign up Form</h1>
			<hr>
			<form action="Signup" method="post">
			
				<input class = "input-text" type="text" placeholder="Name" name="username"  autocomplete="off">
				<br>
				<input class = "input-text" type="Password" placeholder="Password" name="password">
				<br>
				<input class = "input-text" type="Password" placeholder="Confirm Password" name="confirm_password">
				<br>
				<input class = "input-text" type="text" placeholder="Email-ID" name="email">
				<br>
				<input class = "input-btn" type="Submit" value="Sign up">
			</form>
			<h2 class="form-login"><u>Already a member? Login</u></h2>
		</div>
		
		
		
	</div>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/login_signup.js" async="true"></script>
	
</body>
</html>