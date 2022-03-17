package com.green.tnt.member0_t.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.tnt.dao.Member0_tDAO;
import com.green.tnt.dto.Member0_tVO;
import com.green.tnt.member0_t.Member0_tService;

import utils.Criteria;

@Service("Member0_tService")
public class Member0_tServiceImpl implements Member0_tService {
	
	@Autowired
	private Member0_tDAO m0tDao;

	@Override
	public List<Member0_tVO> getSearchMember0_tList(String key) {
		
		return m0tDao.getSearchMember0_tList(key);
	}

	@Override
	public int getCountSearchMember0_tList(String key) {
		
		return m0tDao.getCountSearchMember0_tList(key);
	}

	@Override
	public List<Member0_tVO> getListWithPaging(Criteria criteria, String key) {
		
		return m0tDao.getListWithPaging(criteria,key);
	}

	@Override
	public void insertMember0_t(Member0_tVO vo) {
		
		m0tDao.insertMember0_t(vo);
	}
	
	@Override
	public void updateMember0_t(Member0_tVO vo) {

		m0tDao.updateMember0_t(vo);
	}

	@Override
	public void deleteMember0_t(Member0_tVO vo) {
		
		m0tDao.deleteMember0_t(vo);
	}
	
	@Override
	public int countMember0_tList(Member0_tVO vo) {
	
		return m0tDao.countMember0_tList(vo);
	}

	@Override
	public List<Member0_tVO> getM0_tListPaging(Criteria criteria, Member0_tVO vo) {

		return m0tDao.getM0_tListPaging(criteria, vo);
	}

	@Override
	public Member0_tVO getM0_tDetail(Member0_tVO vo) {
		
		return m0tDao.getM0_tDetail(vo);
	}

}
