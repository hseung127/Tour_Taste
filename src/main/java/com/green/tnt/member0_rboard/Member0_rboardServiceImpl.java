package com.green.tnt.member0_rboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.tnt.dao.Member0_rboardDAO;
import com.green.tnt.dto.Member0_rboardVO;

import utils.Criteria;

@Service("member0_rboard")
public class Member0_rboardServiceImpl implements Member0_rboardService {
	@Autowired
	private Member0_rboardDAO m0rDao; 
	@Override
	public Member0_rboardVO getMember0_rboard(Member0_rboardVO vo) {
		
		return m0rDao.getMember0_rboard(vo);
	}

	@Override
	public int countMember0_rboard(String subject) {
		
		return m0rDao.countMember0_rboard(subject);
	}

	@Override
	public List<Member0_rboardVO> listMember0_rboard(String subject) {
		
		return m0rDao.listMember0_rboard(subject);
	}

	@Override
	public List<Member0_rboardVO> ListWithPaging(Criteria criteria, String subject) {
		
		return m0rDao.ListWithPaging(criteria, subject);
	}


	@Override
	public void deletemember0_rboard(int m0rseq) {
		
		 m0rDao.deletemember0_rboard(m0rseq);
	}

}
