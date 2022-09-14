package com.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.database.SqlSessionManager;

public class userid_training_listDAO {

	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	SqlSession session = null;
	int cnt = 0;
	
	//view 조회 DAO
	//해당 유저의 운동 조회
	//유저 id, 운동 이름, 세트, 횟수 등
	public List<userid_training_listVO> select_training(String user_id){
		session = sqlSessionFactory.openSession(true);
		List<userid_training_listVO> vo = null;
		try {
			vo = session.selectList("select_training", user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		
		return vo;
	}
	
	//특정 날짜별 특정 유저의 운동 조회
	public List<userid_training_listVO> select_training_byId(userid_training_listVO vo){
		session = sqlSessionFactory.openSession(true);
		List<userid_training_listVO> resultvo = null;
		try {
			resultvo = session.selectList("cal", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		
		return resultvo;
		
	}
}
