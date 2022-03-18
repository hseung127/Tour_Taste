package com.green.tnt.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tnt.dto.EventboardVO;
import com.green.tnt.dto.Member1_tboardVO;

import utils.Criteria;

@Repository
public class EventboardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public EventboardVO getEventboard(int eseq) {

		return mybatis.selectOne("mappings.eventboard-mapping.getEventboard", eseq);
	}

	public int countEventboard(Criteria criteria) {

		return mybatis.selectOne("mappings.eventboard-mapping.countEventboardList", criteria);
	}

	public List<EventboardVO> listEventboard(String subject) {

		return mybatis.selectList("mappings.eventboard-mapping.listEventboard", subject);
	}

	public List<EventboardVO> ListWithPaging(Criteria criteria) {

		return mybatis.selectList("mappings.eventboard-mapping.listWithPaging", criteria);
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
	public void eventboardHit(int eseq) {
		mybatis.update("mappings.eventboard-mapping.eventboardHit",eseq);
	}
}
