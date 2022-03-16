package com.green.tnt.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tnt.dto.EventVO;
import com.green.tnt.dto.NewsVO;

import utils.Criteria;

@Repository
public class NewsDAO  {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	
	public List<NewsVO> getHomeNewsList(){
		return mybatis.selectList("mappings.news-mapping.getHomeNewsList");
	}
	
	
	// 전체 상품의 갯수 조회
	public int getCountNewsList() {	
		return mybatis.selectOne("mappings.news-mapping.countNewsList");
	}
	
	
	
	//페이지별 이벤트 목록 조회
	public List<NewsVO> getListWithPaging(Criteria criteria) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		
		return mybatis.selectList("mappings.news-mapping.listWithPaging", map);
	}

}
