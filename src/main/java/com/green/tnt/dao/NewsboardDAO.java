package com.green.tnt.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tnt.dto.NewsboardVO;

import utils.Criteria;

@Repository
public class NewsboardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public NewsboardVO getNewsboard(NewsboardVO vo) {

		return mybatis.selectOne("mappings.newsboard-mapping.getNewsboard", vo);
	}

	public int countNewsboardList(Criteria cri) {

		return mybatis.selectOne("mappings.newsboard-mapping.countNewsboardList", cri);
	}

	public List<NewsboardVO> listNewsboard(String subject) {

		return mybatis.selectList("mappings.newsboard-mapping.listNewsboard", subject);
	}

	public List<NewsboardVO> getListWithPaging(Criteria criteria) {

		return mybatis.selectList("mappings.newsboard-mapping.listWithPaging", criteria);
	}

	public void insertNewsboard(NewsboardVO vo) {
		mybatis.insert("mappings.newsboard-mapping.insertNewsboard", vo);

	}

	public void updateNewsboard(NewsboardVO vo) {
		mybatis.update("mappings.newsboard-mapping.updateNewsboard", vo);

	}

	public void deleteNewsboard(int nseq) {
		mybatis.delete("mappings.newsboard-mapping.deleteNewsboard", nseq);
	}
	
	public void newsboardHit(NewsboardVO vo) {
		mybatis.update("mappings.newsboard-mapping.newsboardHit",vo);
	}
		

}


