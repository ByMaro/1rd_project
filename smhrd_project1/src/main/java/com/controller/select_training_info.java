package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.training_infoDAO;
import com.model.training_infoVO;

@WebServlet("/select_training_info")
public class select_training_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	//사용자별 운동 정보 처리 
	
	int training_index = Integer.parseInt(request.getParameter("training_index"));
	
	training_infoDAO dao = new training_infoDAO();
	
	training_infoVO vo = dao.select_training_info(training_index);
	
	request.setAttribute("vo", vo);
	
	RequestDispatcher rd = request.getRequestDispatcher("exercise.jsp");
	rd.forward(request, response);
	
	
	}

}
