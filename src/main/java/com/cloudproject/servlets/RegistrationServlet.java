package com.cloudproject.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cloudproject.beans.UserBean;
import com.cloudproject.db.RegistrationDb;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");  
	    PrintWriter out = response.getWriter(); 
	    UserBean user = new UserBean();
	    user.setUsername(request.getParameter("name"));
	    user.setUserId(request.getParameter("email"));
	    user.setPassword(request.getParameter("password"));
	    if(RegistrationDb.regiser(user)) {
//	    	HttpSession session = request.getSession(true);
//			session.setAttribute("currentSessionUser", user);
			response.sendRedirect("WelcomeHomePage.jsp");
	    } else {
	    	out.print("Error while registration! Please try again");
	    }
	}
}
