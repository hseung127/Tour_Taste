package com.green.tnt.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tnt.dto.Member0_tboardVO;
import com.green.tnt.dto.Member1_tboardVO;

import utils.Criteria;

@Repository
public class Member0_tboardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public Member0_tboardVO getMember0_tboard(int m0tseq) {

		return mybatis.selectOne("mappings.member0_tboard-mapping.getMember0_tboard", m0tseq);
	}

	public int countMember0_tboard(Criteria criteria) {

		return mybatis.selectOne("mappings.member0_tboard-mapping.countMember0_tboardList", criteria);
	}

	public List<Member0_tboardVO> listMember0_tboard(String subject) {

		return mybatis.selectList("mappings.member0_tboard-mapping.listMember0_tboard", subject);
	}

	public List<Member0_tboardVO> ListWithPaging(Criteria criteria) {

		return mybatis.selectList("mappings.member0_tboard-mapping.listWithPaging", criteria);
	}
	

	public void deletemember0_tboard(int m0tseq) {
		mybatis.delete("mappings.member0_tboard-mapping.deletemember0_tboard", m0tseq);

	}
	public void member0_tboardHit(int m0tseq) {
		mybatis.update("mappings.member0_tboard-mapping.member0_tboardHit",m0tseq);
	}
}
