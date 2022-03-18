package com.green.tnt.news;

import java.util.List;

import com.green.tnt.dto.NewsVO;

import utils.Criteria;

public interface NewsService {

	List<NewsVO> getHomeNewsList();
	
	public int getCountNewsList();
	
	public List<NewsVO> getListWithPaging(Criteria criteria);

	public NewsVO getSelectNewsDetail(String nseq); 
	
	public NewsVO newsViewCount(String nseq);
}