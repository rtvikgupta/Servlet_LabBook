package com.capgemini.lab3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.lab3.dao.DbDaoImpl;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int tid = Integer.parseInt(request.getParameter("tid"));
		String tname = request.getParameter("tname");
		int tseat = Integer.parseInt(request.getParameter("tseat"));
		
		Connection con = new DbDaoImpl().getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into training values (?,?,?)");
			ps.setInt(1, tid);
			ps.setString(2, tname);
			ps.setInt(3, tseat);
			ResultSet rs = ps.executeQuery();
			out.print("Successfully Added "+tname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
