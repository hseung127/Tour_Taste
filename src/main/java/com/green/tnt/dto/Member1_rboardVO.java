package com.green.tnt.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Member1_rboardVO {
	/*
	 *    m1rseq       NUMBER(10) PRIMARY KEY,    --�Խù���ȣ
    subject     VARCHAR2(300), --����(��ȣ��)
    kind        CHAR(1),       --1:�ѽ�, 2:�߽�, 3:�Ͻ�, 4:���, 5:ī��, 6:�н�, 7:�н�ƮǪ��
    address     VARCHAR2(300),  --���ּ�
    area        VARCHAR2(200),     --����
    content     VARCHAR2(4000),  -- ���� �Ұ�(����)
    phone       VARCHAR2(30),     --��ȭ��ȣ 
    image1 VARCHAR2(200),   --�̹��� 5������ ÷�� ����
    image2 VARCHAR2(200),
    image3 VARCHAR2(200),
    image4 VARCHAR2(200),
    image5 VARCHAR2(200),
    id          VARCHAR2(30), 
    name        VARCHAR2(30),-- �۵���� ������ NAME
    regdate     DATE DEFAULT SYSDATE,  --�ۼ���
    FOREIGN KEY(id) REFERENCES member(id)
	 */
	private int m1rseq;
	private String subject;
	private String kind;
	private String address;
	private String area;
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
