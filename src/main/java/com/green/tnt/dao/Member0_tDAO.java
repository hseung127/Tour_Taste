package com.green.tnt.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.green.tnt.dto.Member0_tVO;

import utils.Criteria;

@Repository
public class Member0_tDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//검색 목록 3개 조회 
	public List<Member0_tVO> getSearchMember0_tList(String key){
		return mybatis.selectList("mappings.member0_t-mapping.getSearchMember0_tList",key);
	}

	
	// 전체 검색 목록 갯수 조회
	public int getCountSearchMember0_tList(String key) {	
		return mybatis.selectOne("mappings.member0_t-mapping.countSearchMember0_tList",key);
	}
	
	//페이지별 검색목록 조회 
	public List<Member0_tVO> getListWithPaging(Criteria criteria, String key) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("key", key);
		return mybatis.selectList("mappings.member0_t-mapping.listWithPaging", map);
	}
	
	// 글 작성
	public void insertMember0_t(Member0_tVO vo) {
		
		mybatis.insert("mappings.member0_t-mapping.insertMember0_t", vo);
	}
	
	// 글 수정
	public void updateMember0_t(Member0_tVO vo) {
		
		mybatis.update("mappings.member0_t-mapping.updateMember0_t", vo);
	}
	
	//글 삭제
	public void deleteMember0_t(Member0_tVO vo) {
		
		mybatis.delete("mappings.member0_t-mapping.deleteMember0_t", vo);
	}
	
	// 글 갯수
	public int countMember0_tList(Member0_tVO vo) {
		
		return mybatis.selectOne("mappings.member0_t-mapping.countMember0_tList", vo);
	}
	
	// 게시판 목록 페이징
	public List<Member0_tVO> getM0_tListPaging(Criteria criteria, Member0_tVO vo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("vo", vo);
		
		return mybatis.selectList("mappings.member0_t-mapping.getM0_tListPaging", map);
	}
	
	// 게시판 상세보기
	public Member0_tVO getM0_tDetail(Member0_tVO vo) {
		
		return mybatis.selectOne("mappings.member0_t-mapping.getM0_tDetail", vo);
	}
}
