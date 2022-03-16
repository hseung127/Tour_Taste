package com.green.tnt.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tnt.dto.EventboardVO;

import utils.Criteria;

@Repository
public class EventboardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public EventboardVO getEventboard(EventboardVO vo) {

		return mybatis.selectOne("mappings.eventboard-mapping.getEventboard", vo);
	}

	public int countEventboard(String subject) {

		return mybatis.selectOne("mappings.eventboard-mapping.countEventboardList", subject);
	}

	public List<EventboardVO> listEventboard(String subject) {

		return mybatis.selectList("mappings.eventboard-mapping.listEventboard", subject);
	}

	public List<EventboardVO> ListWithPaging(Criteria criteria, String subject) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("subject", subject);
		return mybatis.selectList("mappings.eventboard-mapping.listWithPaging", map);
	}
	public void insertEventboard(EventboardVO vo) {
		mybatis.insert("mappings.eventboard-mapping.insertEventboard", vo);

	}

	public void updateEventboard(EventboardVO vo) {
		mybatis.update("mappings.eventboard-mapping.updateEventboard", vo);

	}

	public void deleteEventboard(int eseq) {
		mybatis.delete("mappings.eventboard-mapping.deleteEventboard", eseq);

	}
}
