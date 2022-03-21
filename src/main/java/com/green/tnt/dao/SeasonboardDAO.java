package com.green.tnt.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tnt.dto.NewsboardVO;
import com.green.tnt.dto.SeasonboardVO;

import utils.Criteria;

@Repository
public class SeasonboardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public SeasonboardVO getSeasonboard(int sseq) {

		return mybatis.selectOne("mappings.seasonboard-mapping.getSeasonboard", sseq);
	}

	public int countSeasonboard(Criteria criteria) {

		return mybatis.selectOne("mappings.seasonboard-mapping.countSeasonboardList", criteria);
	}

	public List<SeasonboardVO> listSeasonboard(String subject) {

		return mybatis.selectList("mappings.seasonboard-mapping.listSeasonboard", subject);
	}

	public List<SeasonboardVO> ListWithPaging(Criteria criteria) {
	
		return mybatis.selectList("mappings.seasonboard-mapping.listWithPaging", criteria);
	}
	public void insertSeasonboard(SeasonboardVO vo) {
		mybatis.insert("mappings.seasonboard-mapping.insertSeasonboard", vo);

	}

	public void updateSeasonboard(SeasonboardVO vo) {
		mybatis.update("mappings.seasonboard-mapping.updateSeasonboard", vo);

	}

	public void deleteSeasonboard(int sseq) {
		mybatis.delete("mappings.seasonboard-mapping.deleteSeasonboard", sseq);

	}
	public void seasonboardHit(int sseq) {
		mybatis.update("mappings.seasonboard-mapping.seasonboardHit",sseq);
	}
		
}
