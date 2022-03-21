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
	public SeasonboardVO getSeasonboard(int sseq) {
		
		return sDao.getSeasonboard(sseq);
	}

	@Override
	public int countSeasonboard(Criteria criteria) {
		
		return sDao.countSeasonboard(criteria);
	}

	@Override
	public List<SeasonboardVO> listSeasonboard(String subject) {
		
		return sDao.listSeasonboard(subject);
	}

	@Override
	public List<SeasonboardVO> ListWithPaging(Criteria criteria) {
		
		return sDao.ListWithPaging(criteria);
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

	@Override
	public void seasonboardHit(int sseq) {
		sDao.seasonboardHit(sseq);
		
	}

}
