package com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

//추천 알고리즘
//각 운동 정보에 대한 정보(index, 운동부위, 운동기구, 운동 난이도) 및 총 합/곱 가중치
public class reco_for_training_infovo {
	   private int training_index;
	   private String training_part;
	   private String training_equip;
	   private String training_dif;
	   private double score;
	   
	   //운동 정보에 대해서만 초기화
	   public reco_for_training_infovo(int training_index, String training_part, String training_equip, String training_dif) {
		      this.training_index = training_index;
		      this.training_part = training_part;
		      this.training_equip = training_equip;
		      this.training_dif = training_dif;
		   }

}
