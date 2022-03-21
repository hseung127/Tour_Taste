package com.green.tnt.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class NewsboardVO {
   /* nseq  NUMBER(10) PRIMARY KEY,    --�Խù���ȣ
    subject VARCHAR2(300), --����
    content VARCHAR2(4000), --����    
    image VARCHAR2(200),   --�̹���
    id VARCHAR2(30), -- �۵���� ������id
    name VARCHAR2(30) DEFAULT '������', -- �۾��� (������ �̸�)
    regdate DATE DEFAULT SYSDATE,  --�ۼ���
    
    */
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
	private Timestamp regdate;
	private int hit;
	private int newimagenum;
	private String detail_image;
}
