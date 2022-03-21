package com.green.tnt.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tnt.dto.Member0_rboardVO;
import com.green.tnt.dto.Member1_tboardVO;

import utils.Criteria;

@Repository
public class Member0_rboardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public Member0_rboardVO getMember0_rboard(int m0rseq) {

		return mybatis.selectOne("mappings.member0_rboard-mapping.getMember0_rboard", m0rseq);
	}

	public int countMember0_rboard(Criteria criteria) {

		return mybatis.selectOne("mappings.member0_rboard-mapping.countMember0_rboardList", criteria);
	}

	public List<Member0_rboardVO> listMember0_rboard(String subject) {

		return mybatis.selectList("mappings.member0_rboard-mapping.listMember0_rboard", subject);
	}

	public List<Member0_rboardVO> ListWithPaging(Criteria criteria) {

		return mybatis.selectList("mappings.member0_rboard-mapping.listWithPaging", criteria);
	}

	public void deletemember0_rboard(int m0rseq) {
		mybatis.delete("mappings.member0_rboard-mapping.deletemember0_rboard", m0rseq);

	}
	public void member0_rboardHit(int m0rseq) {
		mybatis.update("mappings.member0_rboard-mapping.member0_rboardHit",m0rseq);
	}
}
