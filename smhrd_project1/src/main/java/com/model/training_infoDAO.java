package com.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.database.SqlSessionManager;

public class training_infoDAO {


	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	SqlSession session = null;
	int cnt = 0;
	
	//Ư�� �(�ε����� ����)�� ���� ������ ��ȯ-����
	public training_infoVO select_training_info(int training_index){
		session = sqlSessionFactory.openSession(true);
		training_infoVO vo = null;
		try {
			vo = session.selectOne("select_training_info", training_index);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		
		return vo;
		
	}
	
	
	//Ư�� �(�ε��� ����)�� ���� �̸��� ��ȯ
	public String select_training_name(int training_index){
		session = sqlSessionFactory.openSession(true);
		String vo = null;
		try {
			vo = session.selectOne("select_training_name", training_index);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		
		return vo;
		
	}
	
	

}
