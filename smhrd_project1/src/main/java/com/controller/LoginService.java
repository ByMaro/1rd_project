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
		
		//�α��� ó�� jsp
		
		request.setCharacterEncoding("UTF-8");
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		user_infoVO uvo = new user_infoVO();
		uvo.setUser_id(user_id);
		uvo.setUser_pw(user_pw);
		
		user_infoDAO dao = new user_infoDAO();
		
		//�α��� ��� Ȯ��
		user_infoVO result = dao.login(uvo);

		//�α��� �Ǿ��ٸ�, result�� null ���� �ƴ� �ٸ� ���� ������ ����
		//�α��� ���� �ʾҴٸ�, result�� null ���� ����
		//�α��� ������ session ���� �α��� ���� ����
		if(result != null) {
			System.out.println("�α��� ����");
			
			HttpSession session = request.getSession();
			session.setAttribute("uvo", result);
			response.sendRedirect("main_login_success.jsp");
		}else {
			
			System.out.println("�α��� ����");
			response.sendRedirect("login.html");
		}
	}

}
