package com.green.tnt.member1_t.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.tnt.dao.Member1_tDAO;
import com.green.tnt.dto.Member1_tVO;
import com.green.tnt.member1_t.Member1_tService;

import utils.Criteria;

@Service("Member1_tService")
public class Member1_tServiceImpl implements Member1_tService {
	
	@Autowired
	private Member1_tDAO m1tDao;

	@Override
	public List<Member1_tVO> getHomeMember1_tList() {
		
		return m1tDao.getHomeMember1_tList();
	}

	@Override
	public List<Member1_tVO> getSearchMember1_tList(String key) {
		return m1tDao.getSearchMember1_tList(key);
	}

	@Override
	public int getCountSearchMember1_tList(String key) {
		
		return m1tDao.getCountSearchMember1_tList(key);
	}

	@Override
	public List<Member1_tVO> getListWithPaging(Criteria criteria, String key) {
		
		return m1tDao.getListWithPaging(criteria, key);
	}
	
	@Override
	public List<Member1_tVO> getM1_tListPaging(Criteria criteria, Member1_tVO vo) {
		
		return m1tDao.getM1_tListPaging(criteria, vo);
	}

	@Override
	public int countMember1_tList(Member1_tVO vo) {
		
		return m1tDao.countMember1_tList(vo);
	}

	@Override
	public Member1_tVO getM1_tDetail(Member1_tVO vo) {
		
		return m1tDao.getM1_tDetail(vo);
	}

}
