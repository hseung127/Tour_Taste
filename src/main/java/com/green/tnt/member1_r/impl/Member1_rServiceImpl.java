package com.green.tnt.member1_r.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.tnt.dao.Member1_rDAO;
import com.green.tnt.dto.Member1_rVO;
import com.green.tnt.member1_r.Member1_rService;

import utils.Criteria;


@Service("Member1_rService")
public class Member1_rServiceImpl implements Member1_rService {
	
	@Autowired
	private Member1_rDAO m1rDao;

	@Override
	public List<Member1_rVO> getHomeMember1_rList() {
		return m1rDao.getHomeMember1_rList();
	}

	@Override
	public List<Member1_rVO> getSearchMember1_rList(String key) {
		
		return m1rDao.getSearchMember1_rList(key);
	}

	@Override
	public int getCountSearchMember1_rList(String key) {
		
		return m1rDao.getCountSearchMember1_rList(key);
	}

	@Override
	public List<Member1_rVO> getListWithPaging(Criteria criteria, String key) {
		
		return m1rDao.getListWithPaging(criteria, key);
	}
	
	@Override
	public int countMember1_rList(Member1_rVO vo) {
		
		return m1rDao.countMember1_rList(vo);
	}

	@Override
	public List<Member1_rVO> getM1_rListPaging(Criteria criteria, Member1_rVO vo) {
		
		return m1rDao.getM1_rListPaging(criteria, vo);
	}

	@Override
	public Member1_rVO getM1_rDetail(Member1_rVO vo) {
		
		return m1rDao.getM1_rDetail(vo);
	}

}
