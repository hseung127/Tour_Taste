package com.green.tnt.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tnt.dto.Member0_tboardVO;

import utils.Criteria;

@Repository
public class Member0_tboardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public Member0_tboardVO getMember0_tboard(Member0_tboardVO vo) {

		return mybatis.selectOne("mappings.member0_tboard-mapping.getMember0_tboard", vo);
	}

	public int countMember0_tboard(String subject) {

		return mybatis.selectOne("mappings.member0_tboard-mapping.countMember0_tboardList", subject);
	}

	public List<Member0_tboardVO> listMember0_tboard(String subject) {

		return mybatis.selectList("mappings.member0_tboard-mapping.listMember0_tboard", subject);
	}

	public List<Member0_tboardVO> ListWithPaging(Criteria criteria, String subject) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("subject", subject);
		return mybatis.selectList("mappings.member0_tboard-mapping.listWithPaging", map);
	}
	

	public void deletemember0_tboard(int m0tseq) {
		mybatis.delete("mappings.member0_tboard-mapping.deletemember0_tboard", m0tseq);

	}
}
