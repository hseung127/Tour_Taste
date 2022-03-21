package com.green.tnt.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SeasonboardVO {
	/*sseq  NUMBER(10) PRIMARY KEY,    --�Խù���ȣ
    subject VARCHAR2(300), --����
    content VARCHAR2(4000), --����    
    image1 VARCHAR2(200),   --�̹��� 5������ ÷�� ����
    image2 VARCHAR2(200),
    image3 VARCHAR2(200),
    image4 VARCHAR2(200),
    image5 VARCHAR2(200),
    id VARCHAR2(30), -- �۵���� ������id
    name VARCHAR2(30) DEFAULT '������', -- �۾��� (������ �̸�)
    regdate DATE DEFAULT SYSDATE,  --�ۼ���
    bannerimg VARCHAR2(200), --���� �̹��� 
    FOREIGN KEY(id) REFERENCES member(id)
    
    */
	private int sseq;
	private String subject;
	private String content;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private String image5;
	private String id;
	private String name;
	private String bannerimg;
	private String b_content;
    private Timestamp regdate;
	private int hit;
	
	
}
