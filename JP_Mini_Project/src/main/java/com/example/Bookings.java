package com.example;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Bookings")
public class Bookings extends HttpServlet 
{
	String movieticketcount = "";
	String movietimings = "";
	String movielink = "";
	
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String movie_name = request.getParameter("Movie_Name");
		
		
		
		
		if(request.getSession().getAttribute("username")==null)
		{
			String movieticketcount = request.getParameter("movieticketcounts");
			String movietimings = request.getParameter("movietimings");
			String movielink = request.getParameter("movielink");
			request.getSession().setAttribute("movielink", movielink);
			request.getSession().setAttribute("movietimings", movietimings);
			request.getSession().setAttribute("moviebookedticketcount", movieticketcount);
			System.out.print("Movie ticket count from username null: "+movieticketcount);
			response.sendRedirect("login_signup.jsp");
		}
		else
		{
			if(request.getSession().getAttribute("page_redirect")!=null && !request.getSession().getAttribute("page_redirect").equals("login_signup"))
			{
				String movieticketcount = request.getParameter("movieticketcounts");
				request.getSession().setAttribute("moviebookedticketcount", movieticketcount);
				String movielink = request.getParameter("movielink");
				request.getSession().setAttribute("movielink", movielink);
				String movietimings = request.getParameter("movietimings");
				request.getSession().setAttribute("movietimings", movietimings);
			}
			movieticketcount = (String) request.getSession().getAttribute("moviebookedticketcount");
			movietimings = (String) request.getSession().getAttribute("movietimings");
			movielink = (String) request.getSession().getAttribute("movielink");
			System.out.print("Movie ticket count from username not null: "+movieticketcount);
			String username = (String) request.getSession().getAttribute("username");
			
			
			request.getSession().setAttribute("movie_name_book", movie_name);
			Login_SignupDAO dao = new Login_SignupDAO();
			try 
			{
				dao.insertMovieData(username, movie_name, movieticketcount, movietimings );
				
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			request.getSession().setAttribute("moviebookedtiming", movietimings);
			
			RequestDispatcher rd = request.getRequestDispatcher("bookings.jsp"); 
			
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request,response);
	}

}
