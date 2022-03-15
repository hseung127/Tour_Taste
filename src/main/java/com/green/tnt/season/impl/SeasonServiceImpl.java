package com.green.tnt.season.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.tnt.dao.SeasonDAO;
import com.green.tnt.dto.SeasonVO;
import com.green.tnt.season.SeasonService;

@Service("SeasonService")
public class SeasonServiceImpl implements SeasonService {

	@Autowired
	private SeasonDAO sDao;
	
	@Override
	public List<SeasonVO> getHomeSeasonList() {
		
		return sDao.getHomeSeasonList();
	}

}
