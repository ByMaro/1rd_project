package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//detail_training_rutin_info사용자별루틴 상세 운동
@Data
@AllArgsConstructor
@NoArgsConstructor

//사용자별 운동 기록용
public class user_training_infoVO {
	private int index_no;
	private String user_id;
	private int training_index;
	private int set_val;
	private String secncnt_val;
	private String training_date;
}
