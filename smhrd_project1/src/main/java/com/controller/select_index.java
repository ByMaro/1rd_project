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
import com.model.user_training_infoDAO;
import com.model.user_training_infoVO;

@WebServlet("/select_index")
public class select_index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


		// 접속일에 운동을 추천 받지 않았다면
		// 설문 페이지로 이동
		// 추천 받은 이력(오늘자 운동)이 있다면
		// 운동 상세 페이지로 이동
		user_training_infoDAO dao = new user_training_infoDAO();
		HttpSession session = request.getSession();
		String user_id = ((user_infoVO) session.getAttribute("uvo")).getUser_id();

		user_training_infoVO result = dao.select_index(user_id);

		String nextPage = null;
		if (result != null) {
			nextPage = "detail.jsp";
		} else {
			nextPage = "new_user_survey.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);

	}

}