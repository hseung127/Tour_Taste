package com.green.tnt.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
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
	private String member_info;
}