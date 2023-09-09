package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login_SignupDAO 
{
	String url = "jdbc:mysql://localhost:3306/moviebox";
	String sql1 = "insert into userdata values(?,?,?, null, null, null)";
	String sqluser = "root";
	String sqlpass = "Aditya@15";
	String sql2 = "select * from userdata where name=? and password=?";
	String sql3 = "update moviebox.userdata set moviebookedname =?,moviebookedtiming =  ?, moviebookedticketcount = ? where name=?;";
			
	
	public boolean fetchData(String username, String password) throws SQLException
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, sqluser, sqlpass);
			PreparedStatement pst = con.prepareStatement(sql2);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				return true;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public void insertData(String username, String password, String email) throws SQLException
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, sqluser, sqlpass);
			PreparedStatement pst = con.prepareStatement(sql1);
			pst.setString(1,username);
			pst.setString(2, password);
			pst.setString(3, email);
//			pst.setString(4, "null");
//			pst.setString(5, "null");
//			pst.setString(6, "null");
			pst.executeUpdate();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public void insertMovieData(String username, String moviebookedname, String moviebookedticketcount, String moviebookedtiming) throws SQLException
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, sqluser, sqlpass);
			PreparedStatement pst = con.prepareStatement(sql3);
			pst.setString(4,username);
			pst.setString(1, moviebookedname);
			pst.setString(2, moviebookedtiming);
			pst.setString(3, moviebookedticketcount);
			pst.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
