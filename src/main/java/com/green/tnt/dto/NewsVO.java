package com.green.tnt.dto;


import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NewsVO {

	private int nseq;
	private String subject;
	private String content;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private String image5;
	private String id;
	private String name;
	private Timestamp regdate;//String regdate;
	private int view_count;
}