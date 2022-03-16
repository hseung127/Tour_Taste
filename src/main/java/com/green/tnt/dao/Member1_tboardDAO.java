package com.green.tnt.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tnt.dto.Member1_tboardVO;

import utils.Criteria;

@Repository
public class Member1_tboardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public Member1_tboardVO getMember1_tboard(Member1_tboardVO vo) {

		return mybatis.selectOne("mappings.member1_tboard-mapping.getMember1_tboard", vo);
	}

	public int countMember1_tboard(String subject) {

		return mybatis.selectOne("mappings.member1_tboard-mapping.countMember1_tboardList", subject);
	}

	public List<Member1_tboardVO> listMember1_tboard(String subject) {

		return mybatis.selectList("mappings.member1_tboard-mapping.listMember1_tboard", subject);
	}

	public List<Member1_tboardVO> ListWithPaging(Criteria criteria, String subject) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("subject", subject);
		return mybatis.selectList("mappings.member1_tboard-mapping.listWithPaging", map);
	}
	public void insertMember1_tboard(Member1_tboardVO vo) {
		mybatis.insert("mappings.member1_tboard-mapping.insertMember1_tboard", vo);

	}

	public void updateMember1_tboard(Member1_tboardVO vo) {
		mybatis.update("mappings.member1_tboard-mapping.updateMember1_tboard", vo);

	}
	public void deletemember1_tboard(int m1tseq) {
		mybatis.delete("mappings.member1_tboard-mapping.deletemember1_tboard", m1tseq);

	}
}
