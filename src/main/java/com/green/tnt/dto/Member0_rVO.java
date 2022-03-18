package com.green.tnt.dto;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Member0_rVO {

	private int m0rseq;
	private String subject;
	private String content;
	private String area;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private String image5;
	private String id;
	private String name;
	private Timestamp regdate;
	private MultipartFile uploadFile;

	private String staravg; //메인페이지용 별점 평균 
}
