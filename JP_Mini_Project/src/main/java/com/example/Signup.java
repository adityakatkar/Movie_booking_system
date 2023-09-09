package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("confirm_password");
		String email = (String) request.getParameter("email");
		
		if(!username.equals("") && !password.equals("") && !confirm_password.equals("") && !email.equals(""))
		{
			if(password.equals(confirm_password))
			{
				Login_SignupDAO dao = new Login_SignupDAO();
				try 
				{
					System.out.println(username);				
					dao.insertData(username, password, email);
					response.sendRedirect("index.jsp");
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			
			else
			{
				PrintWriter out = response.getWriter();
				out.print("Error in signing up");
			}
		}
		else
		{
			PrintWriter out = response.getWriter();
			out.print("Error in  filled values");
		}
	}

}
