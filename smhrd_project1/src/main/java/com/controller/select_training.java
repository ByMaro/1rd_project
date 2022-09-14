package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.user_infoVO;
import com.model.userid_training_listDAO;
import com.model.userid_training_listVO;

@WebServlet("/select_training")
public class select_training extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	//login�� ������� ������ ������ �� �ְ� session�� ��������
	HttpSession session = request.getSession();
	//session�ȿ��� ����� ���� ��������(����� ������ ������� ���� --> LoginService)
	user_infoVO uservo =(user_infoVO)session.getAttribute("uvo");
	// vo�ȿ��� ����� ���� ��������
	String user_id = uservo.getUser_id();
	
	
	userid_training_listDAO dao = new userid_training_listDAO();
	
	List<userid_training_listVO> vo = dao.select_training(user_id);
	
	request.setAttribute("vo", vo);
	
	RequestDispatcher rd = request.getRequestDispatcher("exercise.jsp");
	rd.forward(request, response);
	}

}
