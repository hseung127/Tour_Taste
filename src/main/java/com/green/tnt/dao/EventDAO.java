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
	
	
	// ��ü ��ǰ�� ���� ��ȸ
	public int getCountEventList() {	
		return mybatis.selectOne("mappings.event-mapping.countEventList");
	}
	
	
	
	//�������� �̺�Ʈ ��� ��ȸ
	public List<EventVO> getListWithPaging(Criteria criteria) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		
		return mybatis.selectList("mappings.event-mapping.listWithPaging", map);
	}
	
	//�̺�Ʈ ������ ������
	public EventVO getSelectEventDetail(String eseq) {
		
		return mybatis.selectOne("mappings.event-mapping.selectEventDetail", eseq);
	}
	
	//�̺�Ʈ ��ȸ��
	public EventVO EventViewCount(String eseq) {
		
		return mybatis.selectOne("mappings.event-mapping.eventViewCount", eseq);
	}
	
	

}
