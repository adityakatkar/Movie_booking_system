package com.example;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Movie_Individual_Info")
public class Movie_Individual_Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ArrayList<ArrayList<String>> movie_data = new ArrayList<ArrayList<String>>();   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String movie_name = request.getParameter("Movie_Name");
		
		MovieDAO moviedao = new MovieDAO();
		try 
		{
			movie_data = moviedao.fetchMovieData();
			
			for(ArrayList<String> movie_info:movie_data)
			{
				for(String movie_name_data: movie_info)
				{
					if(movie_name_data.equals(movie_name))
					{
						ArrayList<String> asked_movie_info = movie_info;
						request.getSession().setAttribute("asked_movie_info", asked_movie_info);
						RequestDispatcher rd = request.getRequestDispatcher("movie_info.jsp");
						rd.forward(request, response);
						break;
					}
				}
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		
	}
}
