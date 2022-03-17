package com.green.tnt.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tnt.dto.Member1_tVO;
import utils.Criteria;


@Repository
public class Member1_tDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//메인페이지
	public List<Member1_tVO> getHomeMember1_tList(){
		return mybatis.selectList("mappings.member1_t-mapping.getHomeMember1_tList");
	}
	
	//검색 목록 3개 조회 
	public List<Member1_tVO> getSearchMember1_tList(String key){
		return mybatis.selectList("mappings.member1_t-mapping.getSearchMember1_tList",key);
	}

	
	// 전체 검색 목록 갯수 조회
	public int getCountSearchMember1_tList(String key) {	
		return mybatis.selectOne("mappings.member1_t-mapping.countSearchMember1_tList",key);
	}
	
	//페이지별 검색목록 조회 
	public List<Member1_tVO> getListWithPaging(Criteria criteria, String key) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("key", key);
		return mybatis.selectList("mappings.member1_t-mapping.listWithPaging", map);
	}
	
	// 글 갯수
	public int countMember1_tList(Member1_tVO vo) {
		
		return mybatis.selectOne("mappings.member1_t-mapping.countMember1_tList", vo);
	}
	
	// 게시판 목록 페이징
	public List<Member1_tVO> getM1_tListPaging(Criteria criteria, Member1_tVO vo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("vo", vo);
		
		return mybatis.selectList("mappings.member1_t-mapping.getM1_tListPaging", map);
	}
	
	// 게시판 상세보기
	public Member1_tVO getM1_tDetail(Member1_tVO vo) {
		
		return mybatis.selectOne("mappings.member1_t-mapping.getM1_tDetail", vo);
	}
	
}
