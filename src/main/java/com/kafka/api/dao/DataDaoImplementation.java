package com.kafka.api.dao;
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.List;

import com.kafka.api.config.DatabaseConfig;
import com.kafka.api.model.Data; 

public class DataDaoImplementation 
	implements DataDao { 

	static Connection con 
		= DatabaseConfig.getConnection(); 

	@Override
	public int add(Data data) 
		throws SQLException 
	{ 

		String query 
			= "insert into browser_data(user_id, "
			+ "browser_name) VALUES (?, ?)"; 
		PreparedStatement ps 
			= con.prepareStatement(query); 
		ps.setInt(1, data.getUserId()); 
		ps.setString(2, data.getBrowserName()); 
		int n = ps.executeUpdate(); 
		return n; 
	} 

	@Override
	public void delete(int id)throws SQLException 
	{ 
		String query 
			= "delete from browser_data where user_id =?"; 
		PreparedStatement ps 
			= con.prepareStatement(query); 
		ps.setInt(1, id); 
		ps.executeUpdate(); 
	} 

	@Override
	public Data getEmployee(int id) 
		throws SQLException 
	{ 

		String query 
			= "select * from browser_data where emp_id= ?"; 
		PreparedStatement ps 
			= con.prepareStatement(query); 

		ps.setInt(1, id); 
		Data data = new Data(); 
		ResultSet rs = ps.executeQuery(); 
		boolean check = false; 

		while (rs.next()) { 
			check = true; 
			data.setUserId(rs.getInt("user_id")); 
			data.setBrowserName(rs.getString("browser_name")); 
		} 

		if (check == true) { 
			return data; 
		} 
		else
			return null; 
	} 

	@Override
	public List<Data> getEmployees() 
		throws SQLException 
	{ 
		String query = "select * from browser_data"; 
		PreparedStatement ps 
			= con.prepareStatement(query); 
		ResultSet rs = ps.executeQuery(); 
		List<Data> ls = new ArrayList(); 

		while (rs.next()) { 
			Data emp = new Data(); 
			emp.setUserId(rs.getInt("emp_id")); 
			emp.setBrowserName(rs.getString("browser_name")); 
			ls.add(emp); 
		} 
		return ls; 
	} 

	@Override
	public void update(Data data) 
		throws SQLException 
	{ 

		String query 
			= "update browser_data set browser_name=? "
			+ " where user_id = ?"; 
		PreparedStatement ps 
			= con.prepareStatement(query); 
		ps.setInt(1, data.getUserId()); 
		ps.setString(2, data.getBrowserName()); 
		ps.executeUpdate(); 
	}
 
} 

