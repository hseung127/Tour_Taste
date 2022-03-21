package com.green.tnt.member1_tboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.tnt.dao.Member1_tboardDAO;
import com.green.tnt.dto.Member1_tboardVO;

import utils.Criteria;

@Service("member1_tboard")
public class Member1_tboardServiceImpl implements Member1_tboardService {
	@Autowired
	private Member1_tboardDAO m1tDao; 
	
	@Override
	public Member1_tboardVO getMember1_tboard(int m1tseq) {
		
		return m1tDao.getMember1_tboard(m1tseq);
	}

	@Override
	public int countMember1_tboard(Criteria criteria) {
		
		return m1tDao.countMember1_tboard(criteria);
	}

	@Override
	public List<Member1_tboardVO> listMember1_tboard(String subject) {
		
		return m1tDao.listMember1_tboard(subject);
	}

	@Override
	public List<Member1_tboardVO> ListWithPaging(Criteria criteria) {
		
		return m1tDao.ListWithPaging(criteria);
	}


	@Override
	public void deletemember1_tboard(int m1tseq) {
		
		 m1tDao.deletemember1_tboard(m1tseq);
	}
	@Override
	public void insertMember1_tboard(Member1_tboardVO vo) {
		m1tDao.insertMember1_tboard(vo);
		
	}

	@Override
	public void updateMember1_tboard(Member1_tboardVO vo) {
		m1tDao.updateMember1_tboard(vo);
		
	}

	@Override
	public void member1_tboardHit(int m1tseq) {
		m1tDao.member1_tboardHit(m1tseq);
		
	}

}
