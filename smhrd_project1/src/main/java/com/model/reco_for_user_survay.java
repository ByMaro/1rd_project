package com.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class reco_for_user_survay {
	  private String level[] = new String[2]; // 난이도
	  private String favor_part[] = new String[2]; // 선호 부위
	  private String hate_favor_part; // 비선호 부위
	  private String yesterday_part[][] = new String[2][3]; // 어제자, 이틀전 부위
	  private String eq[] = new String[2]; // 선호 장비

}
