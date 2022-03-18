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
	
	
	// ��ü ��ǰ�� ���� ��ȸ
	public int getCountNewsList() {	
		return mybatis.selectOne("mappings.news-mapping.countNewsList");
	}
	
	
	
	//�������� �̺�Ʈ ��� ��ȸ
	public List<NewsVO> getListWithPaging(Criteria criteria) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		
		return mybatis.selectList("mappings.news-mapping.listWithPaging", map);
	}

	
	
	//�̺�Ʈ ������ ������
	public NewsVO getSelectNewsDetail(String nseq) {
		
		return mybatis.selectOne("mappings.news-mapping.selectNewsDetail", nseq);
	}
	
	//�̺�Ʈ ��ȸ��
	public NewsVO newsViewCount(String nseq) {
		
		return mybatis.selectOne("mappings.news-mapping.newsViewCount", nseq);
	}
	
}