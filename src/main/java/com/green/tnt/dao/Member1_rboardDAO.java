package com.green.tnt.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tnt.dto.Member1_rboardVO;

import utils.Criteria;

@Repository
public class Member1_rboardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public Member1_rboardVO getMember1_rboard(Member1_rboardVO vo) {

		return mybatis.selectOne("mappings.member1_rboard-mapping.getMember1_rboard", vo);
	}

	public int countMember1_rboard(String subject) {

		return mybatis.selectOne("mappings.member1_rboard-mapping.countMember1_rboardList", subject);
	}

	public List<Member1_rboardVO> listMember1_rboard(String subject) {

		return mybatis.selectList("mappings.member1_rboard-mapping.listMember1_rboard", subject);
	}

	public List<Member1_rboardVO> ListWithPaging(Criteria criteria, String subject) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("subject", subject);
		return mybatis.selectList("mappings.member1_rboard-mapping.listWithPaging", map);
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
}
