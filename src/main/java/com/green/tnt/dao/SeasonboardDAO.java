package com.green.tnt.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tnt.dto.SeasonboardVO;

import utils.Criteria;

@Repository
public class SeasonboardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public SeasonboardVO getSeasonboard(SeasonboardVO vo) {

		return mybatis.selectOne("mappings.seasonboard-mapping.getSeasonboard", vo);
	}

	public int countSeasonboard(String subject) {

		return mybatis.selectOne("mappings.seasonboard-mapping.countSeasonboardList", subject);
	}

	public List<SeasonboardVO> listSeasonboard(String subject) {

		return mybatis.selectList("mappings.seasonboard-mapping.listSeasonboard", subject);
	}

	public List<SeasonboardVO> ListWithPaging(Criteria criteria, String subject) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("subject", subject);
		return mybatis.selectList("mappings.seasonboard-mapping.listWithPaging", map);
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
}
