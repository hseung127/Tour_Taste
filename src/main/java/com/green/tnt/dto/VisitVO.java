package com.green.tnt.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class VisitVO {
	
	 private int visit_seq;
     private int visit_ip;
     private int visit_time;
     private int visit_refer;
     private int visit_agent;
     
     
     public VisitVO(int visit_seq, int visit_ip, int visit_time, int visit_refer, int visit_agent) {
		this.visit_seq = visit_seq;
		this.visit_ip = visit_ip;
		this.visit_time = visit_time;
		this.visit_refer = visit_refer;
		this.visit_agent = visit_agent;
	}
    public VisitVO() {
    	
    }
     
 
}
