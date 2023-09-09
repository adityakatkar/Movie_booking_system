<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>    
<%@page import="java.util.*"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MovieBox</title>
<link rel="icon" type="image/x-icon" href="movie_logo_2.png">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Inter&family=Poppins:wght@400;500&display=swap" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/movie_info.css">
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
		
		<%
		String username = (String) request.getSession().getAttribute("username");
		String movie_info_name = "movie_info";

		request.getSession().setAttribute("page_redirect", movie_info_name);
						
		if(username != null) {
		%>
			<h1 class="nav-header2" >Welcome <%= username %></h1>
		<%
		}
		%>
		
		<%
		if(username != null) {
		%>
			<button class="nav-button2"><a href="Logout">Logout</a></button>
		<%
		} else {
		%>
			<button class="nav-button"><a href="login_signup.jsp">Login</a></button>
		<%
		}
		%>
	</div>
	
	<div class="movie-info">
	
		<table style="width:90%; margin-top:50px" align="center" cellpadding="15px">
		
			<tr>
				<td rowspan="4">
				<%
				ArrayList<String> movie_info = (ArrayList<String>) request.getSession().getAttribute("asked_movie_info"); 
				if(movie_info != null) {
					String movie_link = movie_info.get(1);
				%>
					<img src="<%= movie_link %>"></img>
				<%
				}
				%>
				</td>
				<td class="movie-info-td"><button class="button"><%= movie_info.get(0) %></button> </td>
			</tr>
				
			<tr>
				<td class="movie-info-td"><button  class="button"><%= movie_info.get(5) %></button></td>
			</tr>
			
			<tr>
				<td class="movie-info-td"><button class="button2"><%= movie_info.get(7) %></button></td>
			</tr>
			
			<tr> 
				<td class="movie-info-td">
					<button class="button3"><%= movie_info.get(2) %> / 10</button>
					<button class="button3"><%= movie_info.get(3) %></button>
					<button class="button3"><%= movie_info.get(4) %></button>
					<button class="button3"><%= movie_info.get(6) %></button>
				</td>
			</tr>
		</table>
		<%request.getSession().setAttribute("movie_name_redirect", movie_info.get(0)); %>
		<hr>
	</div>
	
	<div class="container">
		<!-- seat layout code here (omitted for brevity) -->
	</div>
	
	<%
	Date date = new Date();		
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(date);
	int day = calendar.get(Calendar.DAY_OF_MONTH);	
	%>
	
	<div class="booking">
		<form action="Bookings?Movie_Name=<%= movie_info.get(0) %>" method="post">
			<input type="hidden" value="" name="movieticketcounts" id="ticketcount">
			<input type="hidden" value="<%= movie_info.get(1) %>" name="movielink" id="movielink">
			<input type="datetime-local" name="movietimings" value="2023-05-<%= day %>T13:00" min="2023-05-<%= day+1 %>T08:00" max="2023-06-01T08:00" step="10800" id="inputtime" style="margin-left:800px; height:30px; background-color:#fdfdfd; color:black; font-family:Poppins; font-size:20px; border-radius:20px; text-align:center; margin-top:30px; margin-bottom:30px; padding:10px">
			<br>
			<input type="submit" value="Book : <%= movie_info.get(0) %>" id="button-book" class="button2" style="margin-left:555px; margin-top:30px">
		</form>
	</div>
	
	<br>
	<br>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/bookings.js" async="true"></script>
	
</body>
</html>
