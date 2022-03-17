package com.green.tnt.member0_r.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.tnt.dao.Member0_rDAO;
import com.green.tnt.dto.Member0_rVO;
import com.green.tnt.member0_r.Member0_rService;

import utils.Criteria;

@Service("Member0_rService")
public class Member0_rServiceImpl implements Member0_rService {
	
	@Autowired
	private Member0_rDAO m0rDao;


	@Override
	public List<Member0_rVO> getHomeMember0_rList() {
	
		return m0rDao.getHomeMember0_rList();
	}


	@Override
	public List<Member0_rVO> getSearchMember0_rList(String key) {
		
		return m0rDao.getSearchMember0_rList(key);
	}


	@Override
	public int getCountSearchMember0_rList(String key) {
		
		return m0rDao.getCountSearchMember0_rList(key);
	}


	@Override
	public List<Member0_rVO> getListWithPaging(Criteria criteria, String key) {
		
		return m0rDao.getListWithPaging(criteria, key);
	}

	@Override
	public void insertMember0_r(Member0_rVO vo) {

		m0rDao.insertMember0_r(vo);
	}

	@Override
	public void updateMember0_r(Member0_rVO vo) {

		m0rDao.updateMember0_r(vo);
	}

	@Override
	public void deleteMember0_r(Member0_rVO vo) {
		
		m0rDao.deleteMember0_r(vo);
	}

	@Override
	public int countMember0_rList(Member0_rVO vo) {
		
		return m0rDao.countMember0_rList(vo);
	}


	@Override
	public List<Member0_rVO> getM0_rListPaging(Criteria criteria, Member0_rVO vo) {

		return m0rDao.getM0_rListPaging(criteria, vo);
	}


	@Override
	public Member0_rVO getM0_rDetail(Member0_rVO vo) {

		return m0rDao.getM0_rDetail(vo);
	}
}
