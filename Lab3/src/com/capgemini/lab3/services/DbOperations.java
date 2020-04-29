package com.capgemini.lab3.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.lab3.dao.DbDaoImpl;

public class DbOperations {

	Connection con = new DbDaoImpl().getConnection();
	
	public ResultSet viewDb() throws SQLException
	{
		PreparedStatement ps = con.prepareStatement("select * from training");
		ResultSet rs = ps.executeQuery();
		return rs;
	}

	
}
