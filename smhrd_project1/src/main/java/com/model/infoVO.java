package com.model;

//추천 알고리즘 사용용 VO
//운동 정보 + 가중치 결과 값(score)

public class infoVO {
	int training_index;
	String training_part;
	String training_equip;
	String training_dif;
	double score;

	public int getTraining_index() {
		return training_index;
	}

	public void setTraining_index(int training_index) {
		this.training_index = training_index;
	}

	public String getTraining_part() {
		return training_part;
	}

	public void setTraining_part(String training_part) {
		this.training_part = training_part;
	}

	public String getTraining_equip() {
		return training_equip;
	}

	public void setTraining_equip(String training_equip) {
		this.training_equip = training_equip;
	}

	public String getTraining_dif() {
		return training_dif;
	}

	public void setTraining_dif(String training_dif) {
		this.training_dif = training_dif;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public void info_vo(int training_index, String training_part, String training_equip, String training_dif) {
		this.training_index = training_index;
		this.training_part = training_part;
		this.training_equip = training_equip;
		this.training_dif = training_dif;
	}

}

class user_info {
	String level[] = new String[2]; // 난이도
	String favor_training_part[] = new String[2]; // 선호 부위
	String hate_favor_training_part; // 비선호 부위
	String yesterday_training_part[][] = new String[2][2]; // 어제자, 이틀전 부위
	String eq[] = new String[2]; // 선호 장비

	public user_info(String[] level, String[] favor_training_part, String hate_favor_training_part, String[][] yesterday_training_part,
			String[] eq) {
		super();
		this.level = level;
		this.favor_training_part = favor_training_part;
		this.hate_favor_training_part = hate_favor_training_part;
		this.yesterday_training_part = yesterday_training_part;
		this.eq = eq;
	}

	public String[] getLevel() {
		return level;
	}

	public void setLevel(String[] level) {
		this.level = level;
	}

	public String[] getFavor_training_part() {
		return favor_training_part;
	}

	public void setFavor_training_part(String[] favor_training_part) {
		this.favor_training_part = favor_training_part;
	}

	public String getHate_favor_training_part() {
		return hate_favor_training_part;
	}

	public void setHate_favor_training_part(String hate_favor_training_part) {
		this.hate_favor_training_part = hate_favor_training_part;
	}

	public String[][] getYesterday_training_part() {
		return yesterday_training_part;
	}

	public void setYesterday_training_part(String[][] yesterday_training_part) {
		this.yesterday_training_part = yesterday_training_part;
	}

	public String[] getEq() {
		return eq;
	}

	public void setEq(String[] eq) {
		this.eq = eq;
	}

}

class score_list {
	double level_score = 1;
	double favor_training_part_score = 1;
	double hate_training_part_score = 1;
	double yesterday_training_part_score = 1;
	double eq_score = 1;

	public double getLevel_score() {
		return level_score;
	}

	public void setLevel_score(double level_score) {
		this.level_score = level_score;
	}

	public double getFavor_training_part_score() {
		return favor_training_part_score;
	}

	public void setFavor_training_part_score(double favor_training_part_score) {
		this.favor_training_part_score = favor_training_part_score;
	}

	public double getHate_training_part_score() {
		return hate_training_part_score;
	}

	public void setHate_training_part_score(double hate_training_part_score) {
		this.hate_training_part_score = hate_training_part_score;
	}

	public double getYesterday_training_part_score() {
		return yesterday_training_part_score;
	}

	public void setYesterday_training_part_score(double yesterday_training_part_score) {
		this.yesterday_training_part_score = yesterday_training_part_score;
	}

	public double getEq_score() {
		return eq_score;
	}

	public void setEq_score(double eq_score) {
		this.eq_score = eq_score;
	}

}