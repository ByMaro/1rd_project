package com.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.model.reco_for_scoreTemp;
import com.model.reco_for_training_infoDAO;
import com.model.reco_for_training_infovo;
import com.model.reco_for_user_survay;
import com.model.reco_select_user_data;
import com.model.training_infoDAO;
import com.model.training_infoVO;
import com.model.user_infoVO;
import com.model.userid_training_listVO;

@WebServlet("/reco_algo")
public class reco_algo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* 
		 * 알고리즘 시작 
		 * 각 운동 항목에 가중치를 설정 
		 * 각 가중치에 대해 곱 연산을 시행
		 * 가중치가 가장 높은 세종류의 운동을 반환하여 추천
		 * ->동일 가중치가 4개 이상일 경우 문제 발생
		 */
		List<reco_for_scoreTemp> score_lists = new ArrayList<reco_for_scoreTemp>();
		reco_for_training_infoDAO dao = new reco_for_training_infoDAO();
		List<reco_for_training_infovo> inVos = dao.reco_training_score_init();

		System.out.println(inVos);

		for (int i = 0; i < inVos.size(); i++)
			score_lists.add(new reco_for_scoreTemp());

		reco_for_training_infoDAO yesterday_dao = new reco_for_training_infoDAO();

		String favor_part1 = request.getParameter("parts1");
		String favor_part2 = request.getParameter("parts2");
		String equip1 = request.getParameter("equip1");
		String equip2 = request.getParameter("equip2");
		String dif1 = request.getParameter("dif1");
		String dif2 = request.getParameter("dif2");
		String hatepart = request.getParameter("hateparts");

//        가중치 호출 여부 확인 코드	      
//	      System.out.println(favor_part1);
//	      System.out.println(favor_part2);
//	      System.out.println(equip1);
//	      System.out.println(equip2);
//	      System.out.println(dif1);
//	      System.out.println(dif2);
//	      System.out.println(hatepart);

		HttpSession session = request.getSession();
		String user_id = ((user_infoVO) session.getAttribute("uvo")).getUser_id();
		String b[] = { favor_part1, favor_part2 };// 선호부위 설정 : index[0] - 1순위 index[1] - 2순위
		String c[] = { equip1, equip2 };// 기구 설정 : index[0] - 1순위 index[1] - 2순위
		String a[] = { dif1, dif2 };// 난이도 설정 : index[0] - 1순위 index[1] - 2순위
		List<String> list1 = yesterday_dao.reco_one_yesterday_training_parts(user_id); // 1일 전 운동 부위
		List<String> list2 = yesterday_dao.reco_two_yesterday_training_parts(user_id); // 2일 전 운동 부위
		// 난이도, 선호부위, 비선호, 했던 운동 부위, 선호 장비

		// 이전 일자 운동 설정
		String[][] d = new String[2][3];

		// 신규 가입자의 경우 이전 운동 기록이 없는 것으로 설정
		// 1일전 운동 기록만 있는 경우에 대한 설정 처리
		if (list1.size() == 0 && list2.size() == 0) {
			for (int i = 0; i < 3; i++) {
				d[0][i] = "-";
				d[1][i] = "-";
			}
		} else if (list2.size() == 0) {
			for (int i = 0; i < 3; i++) {
				d[0][i] = list1.get(i);
				d[1][i] = "-";
			}
		} else {
			for (int i = 0; i < 3; i++) {
				d[0][i] = list1.get(i);
				d[1][i] = list2.get(i);
			}
		}
		reco_for_user_survay ui = new reco_for_user_survay(a, b, hatepart, d, c);

		// 선호부위계산(1순위:1 2순위:0.8 3순위:0.1)
		for (int i = 0; i < inVos.size(); i++) {

			if (ui.getFavor_part()[0].equals(inVos.get(i).getTraining_part())) {
				score_lists.get(i).setFavor_part_score(1);
			} else if (ui.getFavor_part()[1].equals(inVos.get(i).getTraining_part())) {
				score_lists.get(i).setFavor_part_score(0.8);
			} else {
				score_lists.get(i).setFavor_part_score(0.1);
			}
		}
		// 비선호부위 : 비선호의 경우 0처리
		for (int i = 0; i < inVos.size(); i++) {

			if (ui.getHate_favor_part().equals(inVos.get(i).getTraining_part())) {
				score_lists.get(i).setFavor_part_score(0);
			}
		}

		// 기구계산(1순위:0.6 2순위:0.4 3순위:0.2)
		for (int i = 0; i < inVos.size(); i++) {

			if (ui.getEq()[0].equals(inVos.get(i).getTraining_equip())) {
				score_lists.get(i).setEq_score(0.6);
			} else if (ui.getEq()[1].equals(inVos.get(i).getTraining_equip())) {
				score_lists.get(i).setEq_score(0.4);
			} else {
				score_lists.get(i).setEq_score(0.2);
			}
		}
		
		// 난이도 계산(1순위:0.8 2순위:0.6 3순위:0.2)
		for (int i = 0; i < inVos.size(); i++) {

			if (ui.getLevel()[0].equals(inVos.get(i).getTraining_dif())) {
				score_lists.get(i).setLevel_score(0.8);
			} else if (ui.getLevel()[1].equals(inVos.get(i).getTraining_dif())) {
				score_lists.get(i).setLevel_score(0.6);
			} else {
				score_lists.get(i).setLevel_score(0.2);
			}
		}
		
		// 이전 운동 부위 : 기본값 1
		// 1일전 : -0.8 처리
		// 2일전 : -1 처리
		for (int i = 0; i < inVos.size(); i++) {

			for (int j = 0; j < ui.getYesterday_part()[1].length; j++)
				if (ui.getYesterday_part()[1][j].equals(inVos.get(i).getTraining_part())) {
					score_lists.get(i).setYesterday_part_score(score_lists.get(i).getYesterday_part_score() - 0.8);
					break;
				}

			for (int j = 0; j < ui.getYesterday_part()[0].length; j++)
				if (ui.getYesterday_part()[0][j].equals(inVos.get(i).getTraining_part())) {
					score_lists.get(i).setYesterday_part_score(score_lists.get(i).getYesterday_part_score() - 1);
					break;
				}

		}

		// for 끝
		System.out.println("부위가중치:");
		for (int i = 0; i < score_lists.size(); i++) {
			System.out.println(score_lists.get(i).getFavor_part_score());
		}
		System.out.println("기구가중치:");
		for (int i = 0; i < score_lists.size(); i++) {
			System.out.println(score_lists.get(i).getEq_score());
		}
		System.out.println("난이도가중치:");
		for (int i = 0; i < score_lists.size(); i++) {
			System.out.println(score_lists.get(i).getLevel_score());
		}

		System.out.println("이전 날짜 운동 관련 가중치:");
		for (int i = 0; i < score_lists.size(); i++) {
			System.out.println(score_lists.get(i).getYesterday_part_score());
		}
		System.out.println("가중치스코어 총합");
		for (int i = 0; i < score_lists.size(); i++) {
			inVos.get(i).setScore(score_lists.get(i).getLevel_score() * score_lists.get(i).getEq_score()
					* score_lists.get(i).getFavor_part_score() * score_lists.get(i).getYesterday_part_score());
			System.out.println(inVos.get(i).getScore());
		}
		for (int i = 0; i < inVos.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (inVos.get(j).getScore() > inVos.get(i).getScore()) {

					int temp = inVos.get(j).getTraining_index();
					inVos.get(j).setTraining_index(inVos.get(i).getTraining_index());
					inVos.get(i).setTraining_index(temp);
					double temp_sc = inVos.get(j).getScore();
					inVos.get(j).setScore(inVos.get(i).getScore());
					inVos.get(i).setScore(temp_sc);

				}
			}
		}

		training_infoDAO training_info_dao = new training_infoDAO();
		List<Integer> q = new ArrayList<Integer>();

		System.out.println("정렬 후");
		for (int i = inVos.size(); i > inVos.size() - 3; i--) {
			System.out.print(inVos.get(i - 1).getTraining_index() + ":" + inVos.get(i - 1).getScore() + "\t");
			System.out.println(training_info_dao.select_training_name(inVos.get(i - 1).getTraining_index()));

			q.add(inVos.get(i - 1).getTraining_index());

		}

		request.setAttribute("q", q);

		// 추천 결과 운동 전달
		RequestDispatcher rd = request.getRequestDispatcher("exercise.jsp");
		rd.forward(request, response);

	}
}
