package com.kafka.api.config;


import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

public class DatabaseConfig{ 

	private static Connection con = null; 

	static
	{ 
		String url = "jdbc:mysql:// localhost:3306/org"; 
		String user = "root"; 
		String pass = "root"; 
		try { 
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection(url, user, pass); 
		} 
		catch (ClassNotFoundException | SQLException e) { 
			e.printStackTrace(); 
		} 
	} 
	public static Connection getConnection() 
	{ 
		return con; 
	} 
} 

