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
	public EventboardVO getEventboard(EventboardVO vo) {
		
		return eDao.getEventboard(vo);
	}

	@Override
	public int countEventboard(String subject) {
		
		return eDao.countEventboard(subject);
	}

	@Override
	public List<EventboardVO> listEventboard(String subject) {
		
		return eDao.listEventboard(subject);
	}

	@Override
	public List<EventboardVO> ListWithPaging(Criteria criteria, String subject) {
		
		return eDao.ListWithPaging(criteria, subject);
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

}
