package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Movie_Dataset")
public class Movie_Dataset extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ArrayList<ArrayList<String>> movie_data = new ArrayList<ArrayList<String>>();   
   
	
    public void Movie_Data(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
       MovieDAO movie_dao = new MovieDAO();
       PrintWriter out = new PrintWriter(System.out);
       try 
       {
    	   movie_data = movie_dao.fetchMovieData();
    	   Iterator<ArrayList<String>> it = movie_data.iterator();
    	   while(it.hasNext())
    	   {
    		   
    		   out.println(it.next());
    	   }
    	   request.getSession().setAttribute("movies_data", movie_data);
           RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
           rd.forward(request, response);
       } 
       catch (SQLException e) 
       {
    	   e.printStackTrace();
       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Movie_Data(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Movie_Data(request, response);
	}

}
