package com.green.tnt.news.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.tnt.dao.NewsDAO;
import com.green.tnt.dto.NewsVO;
import com.green.tnt.news.NewsService;

import utils.Criteria;

@Service("NewsService")
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsDAO nDao;

	@Override
	public List<NewsVO> getHomeNewsList() {
	
		return nDao.getHomeNewsList();
	}

	

	@Override
	public List<NewsVO> getListWithPaging(Criteria criteria) {
		// TODO Auto-generated method stub
		return nDao.getListWithPaging(criteria);
	}



	@Override
	public int getCountNewsList() {
		// TODO Auto-generated method stub
		return nDao.getCountNewsList();
	}

}
