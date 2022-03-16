package com.green.tnt.eventboard;

import java.util.List;

import com.green.tnt.dto.EventboardVO;

import utils.Criteria;

public interface EventboardService {
	
	EventboardVO getEventboard(EventboardVO vo);

	public int countEventboard(String subject);

	public List<EventboardVO> listEventboard(String subject);

	public List<EventboardVO> ListWithPaging(Criteria criteria, String subject);
	
	public void insertEventboard(EventboardVO vo);

	public void updateEventboard(EventboardVO vo);

	public void deleteEventboard(int eseq);
}
