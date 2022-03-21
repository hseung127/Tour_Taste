package com.green.tnt.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Member0_rboardVO {
	/*
	 *  m0rseq  NUMBER(10) PRIMARY KEY,    --�Խù���ȣ
    subject VARCHAR2(300), --����
    content VARCHAR2(4000), --����    
    image1 VARCHAR2(200),   --�̹��� 5������ ÷�� ����
    image2 VARCHAR2(200),
    image3 VARCHAR2(200),
    image4 VARCHAR2(200),
    image5 VARCHAR2(200),
    id VARCHAR2(30), -- �۵���� ȸ��id
    name VARCHAR2(30), -- �۾��� (ȸ�� �г���)
    regdate DATE DEFAULT SYSDATE,  --�ۼ���
    FOREIGN KEY(id) REFERENCES member(id)
	 */
	
	private int m0rseq;
	private String area;
	private String subject;
	private String content;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private String image5;
	private String id;
	private String name;	//�۾���
	private Timestamp regdate;
	private int hit;
}
