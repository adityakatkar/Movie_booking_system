package com.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MovieDAO 
{
	ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
	
	public ArrayList<ArrayList<String>> fetchMovieData() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/moviebox";
		String sqluser = "root";
		String sqlpass = "Aditya@15";
		String sql = "select * from moviedataset";
		int count=0;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, sqluser, sqlpass);
			Statement pst = con.createStatement();
			
			ResultSet rs = pst.executeQuery(sql);
			
			
			while(rs.next())
			{
				if(count>=70 && count<=90)
				{
					ArrayList <String> single_data = new ArrayList<String>();
					single_data.add(rs.getString(2));
					single_data.add(rs.getString(10));
					single_data.add(rs.getString(3));
					single_data.add(rs.getString(4));
					single_data.add(rs.getString(6));
					single_data.add(rs.getString(7));
					single_data.add(rs.getString(8));
					single_data.add(rs.getString(9));
					data.add(single_data);
				}
				count++;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return data;
	}
}
