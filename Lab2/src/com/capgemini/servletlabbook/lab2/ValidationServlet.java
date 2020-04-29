package com.capgemini.servletlabbook.lab2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidationServlet
 */
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(uname.equals("rtvik") && pass.equals("rtvik"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("ResponseServlet");
			rd.forward(request, response);
		}
		else
		{
			out.print("<h1>Failure!! Username or Password is incorrect.</h1>");
		}
		
	}

}
