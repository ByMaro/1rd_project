package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			// 1.技记 按眉 积己
			HttpSession session = request.getSession();

			// 2. 技记 昏力
			 session.invalidate();

			// 3. 其捞瘤 捞悼
			response.sendRedirect("main.jsp");

	}

}
