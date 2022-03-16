package com.green.tnt.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentsVO {
	/*
	 * com_seq     NUMBER(10) PRIMARY KEY,
    m0rseq  NUMBER(10),
    m0tseq  NUMBER(10),
    content     VARCHAR2(4000),
    regdate     DATE DEFAULT SYSDATE,
    id          VARCHAR2(30), -- memberid
    name        VARCHAR2(30), -- ����� �̸�
    star        char(1), -- �� 1�� 2�� 3�� 4�� 5��
    FOREIGN KEY(id) REFERENCES member(id),
    FOREIGN KEY(m0rseq) REFERENCES member0_rboard(m0rseq),
    FOREIGN KEY(m0tseq) REFERENCES member0_tboard(m0tseq)
	 */
	
	private int com_seq;
	private int m0rseq;
	private int m0tseq;
	private Timestamp regdate;
	private String content;
	private String id;
	private String name;
	private String star;
	
}
