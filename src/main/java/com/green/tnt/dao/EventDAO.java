package com.green.tnt.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.green.tnt.dto.EventVO;

import utils.Criteria;


@Repository
public class EventDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public List<EventVO> getHomeEventList(){
		return mybatis.selectList("mappings.event-mapping.getHomeEventList");
	}
	
	
	public List<EventVO> getBigHomeEventList(){
		return mybatis.selectList("mappings.event-mapping.getBigHomeEventList");
	}
	
	
	// 전체 상품의 갯수 조회
	public int getCountEventList() {	
		return mybatis.selectOne("mappings.event-mapping.countEventList");
	}
	
	
	
	//페이지별 이벤트 목록 조회
	public List<EventVO> getListWithPaging(Criteria criteria) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		
		return mybatis.selectList("mappings.event-mapping.listWithPaging", map);
	}
	
	//이벤트 디테일 페이지
	public EventVO getSelectEventDetail(String eseq) {
		
		return mybatis.selectOne("mappings.event-mapping.selectEventDetail", eseq);
	}
	
	//이벤트 조회수
	public EventVO EventViewCount(String eseq) {
		
		return mybatis.selectOne("mappings.event-mapping.eventViewCount", eseq);
	}
	
	

}
