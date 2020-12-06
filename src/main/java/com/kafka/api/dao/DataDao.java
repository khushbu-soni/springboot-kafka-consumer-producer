package com.kafka.api.dao;

import java.sql.SQLException;
import java.util.List;

import com.kafka.api.model.Data;

public interface DataDao { 
	  
    public int add(Data emp) 
        throws SQLException; 
    public void delete(int id) 
        throws SQLException; 
    public Data getEmployee(int id) 
        throws SQLException; 
    public List<Data> getEmployees() 
        throws SQLException; 
    public void update(Data emp) 
        throws SQLException; 
} 
