package com.model;
//user_info 유저 정보 VO
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//회원가입, 회원정보 호출 VO
public class user_infoVO {
	private String user_id;
	private String user_pw;
	private String nick_name;
	private int height_val;
	private int weight_val;
}
