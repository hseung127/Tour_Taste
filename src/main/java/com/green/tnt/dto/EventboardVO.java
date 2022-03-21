package com.green.tnt.dto;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EventboardVO {
	/*  eseq  NUMBER(10) PRIMARY KEY,    --게시물번호        
    subject VARCHAR2(300), --제목
    content VARCHAR2(4000), --내용
    start_date DATE,         --이벤트 시작일 
    end_date DATE,           --이벤트 종료일
    image1 VARCHAR2(200),   --이미지 5개까지 첨부 가능
    image2 VARCHAR2(200),
    image3 VARCHAR2(200),
    image4 VARCHAR2(200),
    image5 VARCHAR2(200),
    id VARCHAR2(30), -- 글등록한 관리자id
    homeimg VARCHAR2(200), --메인페이지 이벤트 이미지 첨부
    bighome_yn CHAR(1), --메인페이지에 큰사이즈 이벤트 게시 여부 체크   게시함:y 게시안함:n  (글쓸때 체크)
    name VARCHAR2(30) DEFAULT '관리자', -- 글쓴이 (관리자 이름)
    regdate DATE DEFAULT SYSDATE,  --작성일
    FOREIGN KEY(id) REFERENCES member(id)
	    */
	
	private int eseq;
	private String subject;
	private String content;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date start_date;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date end_date;
	
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private String image5;
	private String id;
	private String homeimg; 
	private String bighome_yn;
	private String name;
	private Timestamp regdate;
	private int hit;
	
	
}
