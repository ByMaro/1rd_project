package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//training_infoVO
@Data
@AllArgsConstructor
@NoArgsConstructor

//� ������ ȣ���� ���� VO
//� �ε���, � ����(������), �����, ����, � ���̵� �� ����
public class training_infoVO {
	private int training_index;
	private String training_name;
	//private String act_info;
	private String training_part;
	private String training_equip;
	private String training_dif;
	
	//� ������ ���ؼ��� VO �ʱ�ȭ
	training_infoVO(String training_part){
		this.training_part = training_part;
	}
	
}