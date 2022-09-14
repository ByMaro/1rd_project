package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.user_infoDAO;
import com.model.user_infoVO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//로그인 처리 jsp
		
		request.setCharacterEncoding("UTF-8");
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		user_infoVO uvo = new user_infoVO();
		uvo.setUser_id(user_id);
		uvo.setUser_pw(user_pw);
		
		user_infoDAO dao = new user_infoDAO();
		
		//로그인 결과 확인
		user_infoVO result = dao.login(uvo);

		//로그인 되었다면, result는 null 값이 아닌 다른 값을 가지고 있음
		//로그인 되지 않았다면, result는 null 값을 가짐
		//로그인 성공시 session 값에 로그인 정보 저장
		if(result != null) {
			System.out.println("로그인 성공");
			
			HttpSession session = request.getSession();
			session.setAttribute("uvo", result);
			response.sendRedirect("main_login_success.jsp");
		}else {
			
			System.out.println("로그인 실패");
			response.sendRedirect("login.html");
		}
	}

}
