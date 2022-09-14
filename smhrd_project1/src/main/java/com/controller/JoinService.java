package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.user_infoDAO;
import com.model.user_infoVO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	//회원가입 처리 jsp
	
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	String varify_pw = request.getParameter("varify_pw");
	String nick_name = request.getParameter("nick_name");
	int height_val = Integer.parseInt(request.getParameter("height_val"));
	int weight_val = Integer.parseInt(request.getParameter("weight_val"));
	
	
	user_infoVO uvo = new user_infoVO();
	uvo.setUser_id(user_id);
	if(user_pw.equals(varify_pw)) {
		uvo.setUser_pw(user_pw);
	}
	uvo.setNick_name(nick_name);
	uvo.setHeight_val(height_val);
	uvo.setWeight_val(weight_val);
	
	user_infoDAO dao=new user_infoDAO();
	
	int cnt = dao.joininsert(uvo);
	
	if(cnt>0) {
		HttpSession session = request.getSession();
		session.setAttribute("uvo",uvo);
		
		request.setAttribute("user_id",user_id);
		RequestDispatcher rd = request.getRequestDispatcher("main_login_success.jsp");
		rd.forward(request, response);
	}else {
		System.out.println("회원가입 실패");
		response.sendRedirect("main.jsp");
	}
	
	
	
	}

}
