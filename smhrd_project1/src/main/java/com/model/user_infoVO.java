package com.model;
//user_info ���� ���� VO
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//ȸ������, ȸ������ ȣ�� VO
public class user_infoVO {
	private String user_id;
	private String user_pw;
	private String nick_name;
	private int height_val;
	private int weight_val;
}
