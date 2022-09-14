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
import javax.websocket.Session;

import com.model.reco_for_training_infovo;
import com.model.user_infoVO;
import com.model.user_training_infoDAO;
import com.model.user_training_infoVO;


@WebServlet("/surveyinsert")
public class surveyinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	HttpSession session = request.getSession();
	
	List<Integer> q = (List<Integer>) session.getAttribute("q");
	user_infoVO uservo =(user_infoVO)session.getAttribute("uvo");
	//user_training_infoVO q = (user_training_infoVO) request.getAttribute("q");
	
	
	//추천 알고리즘으로 추천받은 운동의 각각의 index
    int training_index1 = q.get(0);
    int training_index2 = q.get(1);
    int training_index3 = q.get(2);
	String user_id = uservo.getUser_id();
	
	//사용자 입력 세트,횟수 저장
	int set_val1 = Integer.parseInt(request.getParameter("set_val1"));
	String secncnt_val1 = request.getParameter("secncnt_val1");
	
	int set_val2 = Integer.parseInt(request.getParameter("set_val2"));
	String secncnt_val2 = request.getParameter("secncnt_val2");
	
	int set_val3 = Integer.parseInt(request.getParameter("set_val3"));
	String secncnt_val3 = request.getParameter("secncnt_val3");
	
	//유저가 추천 받은 운동의 저장(총 3개)
	user_training_infoVO vo1 = new user_training_infoVO();
	vo1.setTraining_index(training_index1);
	vo1.setUser_id(user_id);
	vo1.setSet_val(set_val1);
	vo1.setSecncnt_val(secncnt_val1);
	
	user_training_infoVO vo2 = new user_training_infoVO();
	vo2.setTraining_index(training_index2);
	vo2.setUser_id(user_id);
	vo2.setSet_val(set_val2);
	vo2.setSecncnt_val(secncnt_val2);
	
	user_training_infoVO vo3 = new user_training_infoVO();
	vo3.setTraining_index(training_index3);
	vo3.setUser_id(user_id);
	vo3.setSet_val(set_val3);
	vo3.setSecncnt_val(secncnt_val3);
	
	
	user_training_infoDAO dao = new user_training_infoDAO();
	int cnt1 = dao.surveyinsert(vo1);
	int cnt2 = dao.surveyinsert(vo2);
	int cnt3 = dao.surveyinsert(vo3);
	
	//운동 저장 성공 여부 확인
	if(cnt3>0) {
		response.sendRedirect("detail.jsp");
	}else {
		System.out.println("실패");
		response.sendRedirect("exercise.jsp");
	}
	
	
	}

}
