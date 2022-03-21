package com.green.tnt.member1_rboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.tnt.dao.Member1_rboardDAO;
import com.green.tnt.dto.Member1_rboardVO;

import utils.Criteria;

@Service("member1_rboard")
public class Member1_rboardServiceImpl implements Member1_rboardService {
	@Autowired
	private Member1_rboardDAO m1rDao; 
	@Override
	public Member1_rboardVO getMember1_rboard(int m1rseq) {
		
		return m1rDao.getMember1_rboard(m1rseq);
	}

	@Override
	public int countMember1_rboard(Criteria criteria) {
		
		return m1rDao.countMember1_rboard(criteria);
	}

	@Override
	public List<Member1_rboardVO> listMember1_rboard(String subject) {
		
		return m1rDao.listMember1_rboard(subject);
	}

	@Override
	public List<Member1_rboardVO> ListWithPaging(Criteria criteria) {
		
		return m1rDao.ListWithPaging(criteria);
	}


	@Override
	public void deletemember1_rboard(int m1rseq) {
		
		 m1rDao.deletemember1_rboard(m1rseq);
	}

	@Override
	public void insertMember1_rboard(Member1_rboardVO vo) {
		m1rDao.insertMember1_rboard(vo);
		
	}

	@Override
	public void updateMember1_rboard(Member1_rboardVO vo) {
		m1rDao.updateMember1_rboard(vo);
		
	}

	@Override
	public void member1_rboardHit(int m1rseq) {
		m1rDao.member1_rboardHit(m1rseq);
		
	}

}
