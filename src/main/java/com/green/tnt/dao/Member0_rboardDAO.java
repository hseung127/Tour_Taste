package com.green.tnt.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tnt.dto.Member0_rboardVO;

import utils.Criteria;

@Repository
public class Member0_rboardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public Member0_rboardVO getMember0_rboard(Member0_rboardVO vo) {

		return mybatis.selectOne("mappings.member0_rboard-mapping.getMember0_rboard", vo);
	}

	public int countMember0_rboard(String subject) {

		return mybatis.selectOne("mappings.member0_rboard-mapping.countMember0_rboardList", subject);
	}

	public List<Member0_rboardVO> listMember0_rboard(String subject) {

		return mybatis.selectList("mappings.member0_rboard-mapping.listMember0_rboard", subject);
	}

	public List<Member0_rboardVO> ListWithPaging(Criteria criteria, String subject) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("subject", subject);
		return mybatis.selectList("mappings.member0_rboard-mapping.listWithPaging", map);
	}

	public void deletemember0_rboard(int m0rseq) {
		mybatis.delete("mappings.member0_rboard-mapping.deletemember0_rboard", m0rseq);

	}
}
