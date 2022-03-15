package com.green.tnt.event.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.tnt.dao.EventDAO;
import com.green.tnt.dto.EventVO;
import com.green.tnt.event.EventService;

import utils.Criteria;

@Service("EventService")
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDAO eDao;
	
	@Override
	public List<EventVO> getHomeEventList() {
		return eDao.getHomeEventList();
	}

	@Override
	public List<EventVO> getBigHomeEventList() {
		return eDao.getBigHomeEventList();
	}

	@Override
	public List<EventVO> getListWithPaging(Criteria criteria) {
		return eDao.getListWithPaging(criteria);
	}

	@Override
	public int getCountEventList() {
		return eDao.getCountEventList();
	}

	@Override
	public EventVO getSelectEventDetail(String eseq) {
		return eDao.getSelectEventDetail(eseq);
	}

	@Override
	public EventVO EventViewCount(String eseq) {
		return eDao.EventViewCount(eseq);
	}
	
	
	

	

}
