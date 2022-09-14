package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.model.training_infoDAO;
import com.model.training_infoVO;
import com.model.user_infoVO;
import com.model.user_training_infoDAO;
import com.model.userid_training_listDAO;
import com.model.userid_training_listVO;

@WebServlet("/cal")
public class cal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// login한 사용자의 정보를 가져올 수 있게 session값 가져오기
		HttpSession session = request.getSession();
		// session안에서 사용자 정보 가져오기(사용자 정보가 만들어진 시점 --> LoginService)

		// 날짜정보 꺼내오기
		String data = request.getParameter("data");

		session.setAttribute("data", data);
		userid_training_listVO usertvo = new userid_training_listVO();


		String user_id = ((user_infoVO) session.getAttribute("uvo")).getUser_id();
		usertvo.setUser_id(user_id);
		usertvo.setTraining_date(data);

		userid_training_listDAO dao = new userid_training_listDAO();

		List<userid_training_listVO> vo = dao.select_training_byId(usertvo);

		// javascript ajax 요청 --> 값을 되돌려주기 위해서는 반드시 servlet안에서 출력
		// servlet안에서 출력을 해주기 위해서는 printwriter
		PrintWriter out = response.getWriter();
		// javascript에서 다루기 쉬운 json구조로 변형해서 보내주기
		// json구조로 변형하려면 GSON라이브러리

		Gson gson = new Gson();
		out.print(gson.toJson(vo));


	}
}