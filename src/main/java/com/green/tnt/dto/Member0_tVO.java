package com.green.tnt.dto;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Member0_tVO {
	
	private int m0tseq;
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
	
}
