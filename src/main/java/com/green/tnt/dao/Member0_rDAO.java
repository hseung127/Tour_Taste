package com.green.tnt.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tnt.dto.Member0_rVO;

import utils.Criteria;

@Repository
public class Member0_rDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//메인페이지
	public List<Member0_rVO> getHomeMember0_rList(){
		return mybatis.selectList("mappings.member0_r-mapping.getHomeMember0_rList");
	}
	
	
	//검색 목록 3개 조회 
	public List<Member0_rVO> getSearchMember0_rList(String key){
		return mybatis.selectList("mappings.member0_r-mapping.getSearchMember0_rList",key);
	}

	
	// 전체 검색 목록 갯수 조회
	public int getCountSearchMember0_rList(String key) {	
		return mybatis.selectOne("mappings.member0_r-mapping.countSearchMember0_rList",key);
	}
	
	//페이지별 검색목록 조회 
	public List<Member0_rVO> getListWithPaging(Criteria criteria, String key) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("key", key);
		return mybatis.selectList("mappings.member0_r-mapping.listWithPaging", map);
	}
	
	// 글 작성
	public void insertMember0_r(Member0_rVO vo) {
		
		mybatis.insert("mappings.member0_r-mapping.insertMember0_r", vo);
	}
	
	// 글 수정
	public void updateMember0_r(Member0_rVO vo) {
		
		mybatis.update("mappings.member0_r-mapping.updateMember0_r", vo);
	}
	
	//글 삭제
	public void deleteMember0_r(Member0_rVO vo) {
		
		mybatis.delete("mappings.member0_r-mapping.deleteMember0_r", vo);
	}
	
	// 글 갯수
	public int countMember0_rList(Member0_rVO vo) {
		
		return mybatis.selectOne("mappings.member0_r-mapping.countMember0_rList", vo);
	}
	
	// 게시판 목록 페이징
	public List<Member0_rVO> getM0_rListPaging(Criteria criteria, Member0_rVO vo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("vo", vo);
		
		return mybatis.selectList("mappings.member0_r-mapping.getM0_rListPaging", map);
	}
	
	// 게시판 상세보기
	public Member0_rVO getM0_rDetail(Member0_rVO vo) {
		
		return mybatis.selectOne("mappings.member0_r-mapping.getM0_rDetail", vo);
	}

}
