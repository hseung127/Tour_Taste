package com.green.tnt.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tnt.dto.Member1_rboardVO;
import com.green.tnt.dto.Member1_tboardVO;

import utils.Criteria;

@Repository
public class Member1_rboardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public Member1_rboardVO getMember1_rboard(int m1rseq) {

		return mybatis.selectOne("mappings.member1_rboard-mapping.getMember1_rboard", m1rseq);
	}

	public int countMember1_rboard(Criteria criteria) {

		return mybatis.selectOne("mappings.member1_rboard-mapping.countMember1_rboardList", criteria);
	}

	public List<Member1_rboardVO> listMember1_rboard(String subject) {

		return mybatis.selectList("mappings.member1_rboard-mapping.listMember1_rboard", subject);
	}

	public List<Member1_rboardVO> ListWithPaging(Criteria criteria) {

		return mybatis.selectList("mappings.member1_rboard-mapping.listWithPaging", criteria);
	}
	public void insertMember1_rboard(Member1_rboardVO vo) {
		mybatis.insert("mappings.member1_rboard-mapping.insertMember1_rboard", vo);

	}

	public void updateMember1_rboard(Member1_rboardVO vo) {
		mybatis.update("mappings.member1_rboard-mapping.updateMember1_rboard", vo);

	}

	public void deletemember1_rboard(int m1rseq) {
		mybatis.delete("mappings.member1_rboard-mapping.deletemember1_rboard", m1rseq);

	}
	public void member1_rboardHit(int m1rseq) {
		mybatis.update("mappings.member1_rboard-mapping.member1_rboardHit",m1rseq);
	}
}
