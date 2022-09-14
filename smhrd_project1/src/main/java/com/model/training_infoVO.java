package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//training_infoVO
@Data
@AllArgsConstructor
@NoArgsConstructor

//운동 정보에 호출을 위한 VO
//운동 인덱스, 운동 정보(삭제됨), 운동부위, 운동장비, 운동 난이도 로 구성
public class training_infoVO {
	private int training_index;
	private String training_name;
	//private String act_info;
	private String training_part;
	private String training_equip;
	private String training_dif;
	
	//운동 부위에 대해서만 VO 초기화
	training_infoVO(String training_part){
		this.training_part = training_part;
	}
	
}