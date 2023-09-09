package com.example;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String movie_name = (String) request.getSession().getAttribute("movie_name_book");
		String movie_link = (String) request.getSession().getAttribute("movielink");
		
		Login_SignupDAO dao = new Login_SignupDAO();
		String movieticketcount = (String) request.getSession().getAttribute("moviebookedticketcount");
		String movietimings = (String) request.getSession().getAttribute("movietimings");
		try {
			if(dao.fetchData(username, password))
			{
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				String page_r = (String) session.getAttribute("page_redirect");
				String movie_info = "movie_info";
				if(page_r!=null)
				{
					if(page_r.equals(movie_info))
					{
						String movie_book_name = (String) session.getAttribute("movie_name_redirect");
						session.setAttribute("moviebookedticketcount", movieticketcount);
						session.setAttribute("movietimings", movietimings);
						session.setAttribute("movielink", movie_link);
						session.setAttribute("page_redirect", "login_signup");
						response.sendRedirect("Bookings?Movie_Name="+movie_book_name);
					}
				}
				else
				{
					response.sendRedirect("home.jsp");
				}
			}
			else
			{
				response.sendRedirect("login_signup.jsp");;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
