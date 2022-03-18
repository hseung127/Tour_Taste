package com.green.tnt.eventboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.tnt.dao.EventboardDAO;
import com.green.tnt.dto.EventboardVO;

import utils.Criteria;

@Service("eventboard")
public class EventboardServiceImpl implements EventboardService {
	@Autowired
	private EventboardDAO eDao; 
	@Override
	public EventboardVO getEventboard(int eseq) {
		
		return eDao.getEventboard(eseq);
	}

	@Override
	public int countEventboard(Criteria criteria) {
		
		return eDao.countEventboard(criteria);
	}

	@Override
	public List<EventboardVO> listEventboard(String subject) {
		
		return eDao.listEventboard(subject);
	}

	@Override
	public List<EventboardVO> ListWithPaging(Criteria criteria) {
		
		return eDao.ListWithPaging(criteria);
	}


	@Override
	public void deleteEventboard(int eseq) {
		
		 eDao.deleteEventboard(eseq);
	}

	@Override
	public void insertEventboard(EventboardVO vo) {
		eDao.insertEventboard(vo);
		
	}

	@Override
	public void updateEventboard(EventboardVO vo) {
		eDao.updateEventboard(vo);
		
	}

	@Override
	public void eventboardHit(int eseq) {
		eDao.eventboardHit(eseq);
		
	}

}
