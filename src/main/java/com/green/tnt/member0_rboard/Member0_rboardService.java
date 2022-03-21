package com.green.tnt.member0_rboard;

import java.util.List;

import com.green.tnt.dto.Member0_rboardVO;

import utils.Criteria;

public interface Member0_rboardService {
	
	Member0_rboardVO getMember0_rboard(int m0rseq);

	public int countMember0_rboard(Criteria criteria);

	public List<Member0_rboardVO> listMember0_rboard(String subject);

	public List<Member0_rboardVO> ListWithPaging(Criteria criteria);

	public void deletemember0_rboard(int m0rseq);
	
	public void member0_rboardHit(int m0rseq);
}
