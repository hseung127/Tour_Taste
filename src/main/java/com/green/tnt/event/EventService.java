package com.green.tnt.event;

import java.util.List;

import com.green.tnt.dto.EventVO;

import utils.Criteria;

public interface EventService {

	public List<EventVO> getHomeEventList();
	
	public List<EventVO> getBigHomeEventList();
	
	public int getCountEventList();
	
	public List<EventVO> getListWithPaging(Criteria criteria); 
	
	public EventVO getSelectEventDetail(String eseq);
	
	public EventVO EventViewCount(String eseq);

}