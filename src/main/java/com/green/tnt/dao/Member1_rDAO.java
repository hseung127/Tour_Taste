package com.green.tnt.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tnt.dto.Member1_rVO;

import utils.Criteria;

@Repository
public class Member1_rDAO  {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//메인페이지
	public List<Member1_rVO> getHomeMember1_rList(){
		return mybatis.selectList("mappings.member1_r-mapping.getHomeMember1_rList");
	}
	
	//검색 목록 3개 조회 
	public List<Member1_rVO> getSearchMember1_rList(String key){
		return mybatis.selectList("mappings.member1_r-mapping.getSearchMember1_rList",key);
	}

	
	// 전체 검색 목록 갯수 조회
	public int getCountSearchMember1_rList(String key) {	
		return mybatis.selectOne("mappings.member1_r-mapping.countSearchMember1_rList",key);
	}
	
	//페이지별 검색목록 조회 
	public List<Member1_rVO> getListWithPaging(Criteria criteria, String key) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("key", key);
		return mybatis.selectList("mappings.member1_r-mapping.listWithPaging", map);
	}
	
	// 글 갯수
	public int countMember1_rList(Member1_rVO vo) {
		
		return mybatis.selectOne("mappings.member1_r-mapping.countMember1_rList", vo);
	}
	
	// 게시판 목록 페이징
	public List<Member1_rVO> getM1_rListPaging(Criteria criteria, Member1_rVO vo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("vo", vo);
		
		return mybatis.selectList("mappings.member1_r-mapping.getM1_rListPaging", map);
	}
	
	// 게시판 상세보기
	public Member1_rVO getM1_rDetail(Member1_rVO vo) {
		
		return mybatis.selectOne("mappings.member1_r-mapping.getM1_rDetail", vo);
	}

}
