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
import com.capgemini.lab3.services.DbOperations;

/**
 * Servlet implementation class DbServlet
 */
public class DbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<html><body><table>");
		out.print("<tr><th>Training Id</th><th>Training Name</th><th>Available Seats</th><th>Action</th></tr>");
		try {
			ResultSet rs = new DbOperations().viewDb();
			while(rs.next()) {
				out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td>"
						+ "<td><a href='ResponseServlet?tname="+rs.getString(2)+"&&seat="+rs.getInt(3)+"'>Enroll</a></td></tr>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.print("</table></body></html>");
	}

}
