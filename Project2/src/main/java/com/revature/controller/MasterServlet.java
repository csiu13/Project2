package com.revature.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.RequestHelper;

public class MasterServlet extends HttpServlet{
	private static final long serialVersionUID = 590444879370100299L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		if(request.getParameter("test") != null) {
			//Runtime.getRuntime().exec("cmd C:\\Users\\Administrator\\Documents\\git_repo\\Project2\\Project2\\src\\test\\java \"\" test.bat");
			request.getRequestDispatcher("../surefire-reports/index.html").forward(request, response);
			//response.getWriter().write(new ObjectMapper().writeValueAsString(System.getProperty("user.dir")));
		} else {
			response.setContentType("text/json");
			response.getWriter().write(
				new ObjectMapper().writeValueAsString(RequestHelper.process(request, response)));
		}

		/* As you can see, any type of object can be written as a JSON 
		 * Jackson specifically requires that objects to be transformed
		 * have getters for private variables */
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json");

		response.getWriter().write(
				new ObjectMapper().writeValueAsString(RequestHelper.process(request, response)));
	}

}