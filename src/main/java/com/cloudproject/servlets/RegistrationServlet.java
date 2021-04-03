package com.cloudproject.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloudproject.db.RegistrationDb;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    String username = request.getParameter("name");
	    String userId = request.getParameter("email");
	    String password = request.getParameter("password");
	    if(RegistrationDb.regiser(userId, username, password)) {
	    	out.println("You are successfully registered");
	    	RequestDispatcher rd = request.getRequestDispatcher("WelcomeServlet");
	    	rd.forward(request, response);
	    } 		
	}
}
