package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class userid_training_listVO {
	private String user_id;
	private String training_name;
	private int set_val;
	private String secncnt_val;
	private String training_date;
}
