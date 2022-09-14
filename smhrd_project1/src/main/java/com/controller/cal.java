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

		// login�� ������� ������ ������ �� �ְ� session�� ��������
		HttpSession session = request.getSession();
		// session�ȿ��� ����� ���� ��������(����� ������ ������� ���� --> LoginService)

		// ��¥���� ��������
		String data = request.getParameter("data");

		session.setAttribute("data", data);
		userid_training_listVO usertvo = new userid_training_listVO();


		String user_id = ((user_infoVO) session.getAttribute("uvo")).getUser_id();
		usertvo.setUser_id(user_id);
		usertvo.setTraining_date(data);

		userid_training_listDAO dao = new userid_training_listDAO();

		List<userid_training_listVO> vo = dao.select_training_byId(usertvo);

		// javascript ajax ��û --> ���� �ǵ����ֱ� ���ؼ��� �ݵ�� servlet�ȿ��� ���
		// servlet�ȿ��� ����� ���ֱ� ���ؼ��� printwriter
		PrintWriter out = response.getWriter();
		// javascript���� �ٷ�� ���� json������ �����ؼ� �����ֱ�
		// json������ �����Ϸ��� GSON���̺귯��

		Gson gson = new Gson();
		out.print(gson.toJson(vo));


	}
}