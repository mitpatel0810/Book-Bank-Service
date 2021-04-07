package com.cloudproject.servlets;
import com.cloudproject.beans.UserBean;
import com.cloudproject.db.LoginValidateDb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print("I am called");
		UserBean user = new UserBean();
		user.setUserId(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		if(LoginValidateDb.validate(user)) {
//			HttpSession session = request.getSession(true);
//			session.setAttribute("currentSessionUser", user);
			response.sendRedirect("WelcomeHomePage.jsp");
		} else {
//			out.print("Sorry, you are not a registered user");
			response.sendRedirect("UserInvalidLogin.jsp");
		}		
	}
}
