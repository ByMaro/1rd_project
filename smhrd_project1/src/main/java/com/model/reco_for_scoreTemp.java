package com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

//각 운동에 대한 초기 가중치 초기화
//운동 난이도, 선호 운동 부위, 비선호 운동 부위,
//이전 운동 부위, 선호 장비에 초기값 설정(초기값 : 1)

public class reco_for_scoreTemp {
	  private double level_score = 1;
	  private double favor_part_score = 1;
	  private double hate_part_score = 1;
	  private double yesterday_part_score = 1;
	  private double eq_score = 1;

}
