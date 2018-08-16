package com.revature.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/ERS/html/listEmployee.do":
			return null;
		default:
			return "404.jsp";
		}
	}
}
