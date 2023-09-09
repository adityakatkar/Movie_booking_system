<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ page isELIgnored="false"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MovieBox</title>
<link rel="icon" type="image/x-icon" href="movie_logo_2.png">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Inter&family=Poppins:wght@400;500&display=swap"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/home.css">
</head>

<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setHeader("Expires", "0"); //Proxies
	%>



	<div class="navigation">
		<img src="movie_logo.png" class="nav-img">
		<h1 class="nav-header">MovieBox</h1>

		<%

				String username = (String) request.getSession().getAttribute("username");
				if (username != null) {
		%>
		<h1 class="nav-header2">
			Welcome <%=username%>
		</h1>
		<%

				}
		%>


		<%

				if (username != null) {
		%>
		<button class="nav-button2">
			<a href="Logout">Logout</a>
		</button>
		<%
				} else {
		%>
		<button class="nav-button">
			<a href="login_signup.jsp">Login</a>
		</button>
		<%
				}
		%>

	</div>
	<div class="movie-list">



		<form action="Movie_DataSet" method="post"></form>

		<table style="width: 90%" align="center" cellpadding="15px">
			<tr>
				<td colspan="4"><h1 style="color: black; font-family: Poppins">Popular
						Movies: You may like</h1></td>
			</tr>



			<%
				ArrayList<ArrayList<String>> movie_data = (ArrayList<ArrayList<String>>) request.getSession().getAttribute("movies_data");
				if (movie_data != null) {
					int counter = 0;
					
				for (int i = 0; i < 5; i++) {
			%>
			<tr style="height: 100px; width: 40px">
				<%
						for (int j = 0; j < 4; j++) {
							String individual_link = "";
							String poster_link = "";
							ArrayList<String> data = movie_data.get(counter);
							counter++;
							int count = 0;
							for (String s : data) {
								count++;
								if (count == 1) {
							individual_link = s;
								}
								if (count == 2) {
							poster_link = s;
				%>
				<td><a
					href="${pageContext.request.contextPath}/Movie_Individual_Info?Movie_Name=<%=individual_link%>"> 
					
						<%
						out.print("<img src=" + '"' + poster_link + '"' + ">");
						%>
						
		
				</a></td>
				<%
				}
				}
				}
				%>
			</tr>
			<%
			}
			}
			%>

		</table>
	</div>

</body>
</html>