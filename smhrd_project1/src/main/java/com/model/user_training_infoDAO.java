package com.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.database.SqlSessionManager;

public class user_training_infoDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	SqlSession session = null;
	int cnt =0;	
	
	//사용자별 추천 운동을 저장 
	public int surveyinsert(user_training_infoVO vo) {
		
		try {
			session = sqlSessionFactory.openSession(true);
			cnt = session.insert("surveyinsert",vo);
		} catch (Exception e) {
		e.printStackTrace();
		}
		session.close();
		return cnt;
	}

	//특정 유저의 오늘자 운동 추천 여부 확인을 위한 DAO
	//추천 받은 경우, 첫번째 운동이 반환
	//추천 받지 않은 경우, NULL 값 반환
	public user_training_infoVO select_index(String user_id) {
		session = sqlSessionFactory.openSession(true);
		user_training_infoVO vo = null;
		try {
			vo = session.selectOne("select_index", user_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return vo;
	}

	
}
