package com.green.tnt.newsboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.green.tnt.dao.NewsboardDAO;
import com.green.tnt.dto.NewsboardVO;

import utils.Criteria;

@Service("newsboardService")
public class NewsboardServiceImpl implements NewsboardService {
	
	@Autowired
	private NewsboardDAO nDao;
	
	
	@Override
	public NewsboardVO getNewsboard(int nseq) {
			
		return nDao.getNewsboard(nseq) ;
	}

	@Override
	public int countNewsboardList(Criteria criteria) {

		return nDao.countNewsboardList(criteria);
	}

	@Override
	public List<NewsboardVO> listNewsboard(String subject) {
	
		return nDao.listNewsboard(subject);
	}

	@Override
	public List<NewsboardVO> getListWithPaging(Criteria criteria) {
		
		return nDao.getListWithPaging(criteria);
	}

	@Override
	public void insertNewsboard(NewsboardVO vo) {
		nDao.insertNewsboard(vo);
	}

	@Override
	public void updateNewsboard(NewsboardVO vo) {
		nDao.updateNewsboard(vo);
	}

	@Override
	public void deleteNewsboard(int nseq) {
		nDao.deleteNewsboard(nseq);
		
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public void newsboardHit(int nseq) {
		nDao.newsboardHit(nseq);
	}

	@Override
	public void insertNewsboardImage(NewsboardVO vo) {
		nDao.insertNewsboardImage(vo);
		
	}








}
