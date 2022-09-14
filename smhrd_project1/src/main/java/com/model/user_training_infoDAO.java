package com.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.database.SqlSessionManager;

public class user_training_infoDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	SqlSession session = null;
	int cnt =0;	
	
	//����ں� ��õ ��� ���� 
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

	//Ư�� ������ ������ � ��õ ���� Ȯ���� ���� DAO
	//��õ ���� ���, ù��° ��� ��ȯ
	//��õ ���� ���� ���, NULL �� ��ȯ
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
