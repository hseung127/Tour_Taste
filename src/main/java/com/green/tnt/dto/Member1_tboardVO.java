package com.green.tnt.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member1_tboardVO {
/*
 *  m1tseq           NUMBER(10) PRIMARY KEY, --�Խù���ȣ
    subject         VARCHAR2(300),         --����(������ �̸�)
    address         VARCHAR2(300),    -- ���ּ�(���θ�)
    area            VARCHAR2(200),   -- ����(��/��)
    convenience        VARCHAR2(300),  --���ǽü�
    content         VARCHAR2(4000),  -- ������ �Ұ�(����)
    phone              VARCHAR2(30), -- ��ȭ��ȣ   
    image1 VARCHAR2(200),   --�̹��� 5������ ÷�� ����
    image2 VARCHAR2(200),
    image3 VARCHAR2(200),
    image4 VARCHAR2(200),
    image5 VARCHAR2(200),
    id              VARCHAR2(30), -- �۵���� ȸ��id
    regdate         DATE DEFAULT SYSDATE,  --�ۼ���
    FOREIGN KEY(id) REFERENCES member(id)
 */
	
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
	private String name;
	private Timestamp regdate;
	private int hit;
}
