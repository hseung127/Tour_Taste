package com.green.tnt.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO{
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String useyn;
	private String authstatus;
	private String authkey;
	private String user_type;
	private Timestamp regdate;	
	private String salt;
}