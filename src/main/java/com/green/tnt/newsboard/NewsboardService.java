package com.green.tnt.newsboard;

import java.util.List;

import com.green.tnt.dto.NewsboardVO;

import utils.Criteria;

public interface NewsboardService {

	NewsboardVO getNewsboard(int nseq);

	public int countNewsboardList(Criteria criteria);

	public List<NewsboardVO> listNewsboard(String subject);

	public List<NewsboardVO> getListWithPaging(Criteria criteria);

	public void insertNewsboard(NewsboardVO vo);
	
	public void insertNewsboardImage(NewsboardVO vo);

	public void updateNewsboard(NewsboardVO vo);

	public void deleteNewsboard(int nseq);
	
	public void newsboardHit(int  nseq);
	
	
	
}