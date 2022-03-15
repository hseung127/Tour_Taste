package com.green.tnt.seasonboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.tnt.dao.SeasonboardDAO;
import com.green.tnt.dto.SeasonboardVO;

import utils.Criteria;

@Service("seasonboard")
public class SeasonboardServiceImpl implements SeasonboardService {
	@Autowired
	private SeasonboardDAO sDao; 
	@Override
	public SeasonboardVO getSeasonboard(SeasonboardVO vo) {
		
		return sDao.getSeasonboard(vo);
	}

	@Override
	public int countSeasonboard(String subject) {
		
		return sDao.countSeasonboard(subject);
	}

	@Override
	public List<SeasonboardVO> listSeasonboard(String subject) {
		
		return sDao.listSeasonboard(subject);
	}

	@Override
	public List<SeasonboardVO> ListWithPaging(Criteria criteria, String subject) {
		
		return sDao.ListWithPaging(criteria, subject);
	}


	@Override
	public void deleteSeasonboard(int sseq) {
		
		 sDao.deleteSeasonboard(sseq);
	}

	@Override
	public void insertSeasonboard(SeasonboardVO vo) {
		sDao.insertSeasonboard(vo);
		
	}

	@Override
	public void updateSeasonboard(SeasonboardVO vo) {
		sDao.updateSeasonboard(vo);
		
	}

}
