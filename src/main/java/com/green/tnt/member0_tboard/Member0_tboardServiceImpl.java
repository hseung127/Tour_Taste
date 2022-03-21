package com.green.tnt.member0_tboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.tnt.dao.Member0_tboardDAO;
import com.green.tnt.dto.Member0_tboardVO;

import utils.Criteria;

@Service("member0_tboard")
public class Member0_tboardServiceImpl implements Member0_tboardService {
	@Autowired
	private Member0_tboardDAO m0tDao; 
	
	@Override
	public Member0_tboardVO getMember0_tboard(int m0tseq) {
		
		return m0tDao.getMember0_tboard(m0tseq);
	}

	@Override
	public int countMember0_tboard(Criteria criteria) {
		
		return m0tDao.countMember0_tboard(criteria);
	}

	@Override
	public List<Member0_tboardVO> listMember0_tboard(String subject) {
		
		return m0tDao.listMember0_tboard(subject);
	}

	@Override
	public List<Member0_tboardVO> ListWithPaging(Criteria criteria) {
		
		return m0tDao.ListWithPaging(criteria);
	}


	@Override
	public void deletemember0_tboard(int m0tseq) {
		
		 m0tDao.deletemember0_tboard(m0tseq);
	}

	@Override
	public void member0_tboardHit(int m0tseq) {
		m0tDao.member0_tboardHit(m0tseq);
		
	}

}
