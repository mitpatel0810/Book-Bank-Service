package com.cloudproject.servlets;
import com.cloudproject.db.LoginValidateDb;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		String userId = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		if(LoginValidateDb.validate(userId, password)) {
			RequestDispatcher rd = request.getRequestDispatcher("WelcomeServlet");
			rd.forward(request, response);
		} else {
			out.println("Username or Password is incorrect!");
			RequestDispatcher rd = request.getRequestDispatcher("UserLogin.html");
			rd.include(request, response);
		}		
	}
}
