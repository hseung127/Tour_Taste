package com.green.tnt.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EventVO {
	private int eseq;
	private String subject;
	private String content;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private String image5;
	private String id;
	private String homeimg;
	private String bighomeimg;
	private String bighome_yn;
	private String name;
	private String start_date;
	private String end_date;
	private Timestamp regdate;
	private int view_count;
	
	
}
