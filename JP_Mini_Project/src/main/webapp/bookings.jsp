<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MovieBox</title>
<link rel="icon" type="image/x-icon" href="movie_logo_2.png">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Inter&family=Poppins:wght@400;500&display=swap" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bookings.css">
</head>

<body>
    <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setHeader("Expires", "0"); // Proxies

    String movie_name = (String) request.getSession().getAttribute("movie_book_name");
    System.out.print(movie_name);

    String username = (String) request.getSession().getAttribute("username");
    %>

    <div class="navigation">
        <a href="home.jsp"><img src="movie_logo.png" class="nav-img" /></a>
        <h1 class="nav-header">MovieBox</h1>

        <% if (username != null) { %>
        <h1 class="nav-header2">Welcome <%= username %></h1>
        <button class="nav-button2"><a href="Logout">Logout</a></button>
        <% } else { %>
        <button class="nav-button"><a href="login_signup.jsp">Login</a></button>
        <% } %>

    </div>

    <% 
    String movie_timings = (String) request.getSession().getAttribute("moviebookedtiming");
    String movie_ticket_count = (String) request.getSession().getAttribute("moviebookedticketcount");
    %>

    <div class="container">
        <div class="details">
            <h1>Booking Details</h1>
            <hr>
            <img class="container-img" src="<%= request.getSession().getAttribute("movielink") %>" />
            <br>
            <button class="button2">Movie: <%= movie_name %></button>
            <button class="button2">User: <%= username %></button>
            <button class="button2">Tickets: <%= movie_ticket_count %></button>
            <button class="button2">Timings: <%= movie_timings %></button>
        </div>
    </div>
</body>
</html>
