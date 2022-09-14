package com.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.database.SqlSessionManager;

public class reco_for_training_infoDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	SqlSession session = null;
	int cnt = 0;

	// 운동정보 + 가중치 최종 값 저장 vo 초기화
	public List<reco_for_training_infovo> reco_training_score_init() {
		session = sqlSessionFactory.openSession(true);
		List<reco_for_training_infovo> vo = null;
		try {
			vo = session.selectList("training_score_init");
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();

		return vo;

	}

	// 1일전 운동 부위에 대한 정보 호출
	public List<String> reco_one_yesterday_training_parts(String user_id) {
		session = sqlSessionFactory.openSession(true);
		List<String> vo = null;

		try {
			vo = session.selectList("reco_one_yesterday_training_parts", user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();

		return vo;

	}

	// 2일전 운동 부위에 대한 종보 호출
	public List<String> reco_two_yesterday_training_parts(String user_id) {
		session = sqlSessionFactory.openSession(true);
		List<String> vo = null;

		try {
			vo = session.selectList("reco_two_yesterday_training_parts", user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();

		return vo;

	}

	// 오늘 추천 받은 운동에 대한 정보들을 호출
	public List<today_user_trainingVO> reco_today_training_parts(String user_id) {
		session = sqlSessionFactory.openSession(true);
		List<today_user_trainingVO> vo = null;

		try {
			vo = session.selectList("reco_today_training_parts", user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();

		return vo;

	}

}