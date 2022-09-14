package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

//오늘자 사용자 운동 정보 호출(세트, 회수 포함)
public class today_user_trainingVO {
   private int training_index;
   private String training_name;
   private int cnt;
   private int set_val;
   private String secncnt_val;
}