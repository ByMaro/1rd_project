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
	  private String level[] = new String[2]; // ���̵�
	  private String favor_part[] = new String[2]; // ��ȣ ����
	  private String hate_favor_part; // ��ȣ ����
	  private String yesterday_part[][] = new String[2][3]; // ������, ��Ʋ�� ����
	  private String eq[] = new String[2]; // ��ȣ ���

}
