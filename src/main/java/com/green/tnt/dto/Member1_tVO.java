package com.green.tnt.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Member1_tVO {
	private int m1tseq;
	private String subject;
	private String address;
	private String area;
	private String convenience;
	private String content;
	private String phone;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private String image5;
	private String id;
	private Timestamp regdate;
	
	/* bookmark */
	private int bseq;
   
}
