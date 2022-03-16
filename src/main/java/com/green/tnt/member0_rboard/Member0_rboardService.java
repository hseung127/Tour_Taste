package com.green.tnt.member0_rboard;

import java.util.List;

import com.green.tnt.dto.Member0_rboardVO;

import utils.Criteria;

public interface Member0_rboardService {
	
	Member0_rboardVO getMember0_rboard(Member0_rboardVO vo);

	public int countMember0_rboard(String subject);

	public List<Member0_rboardVO> listMember0_rboard(String subject);

	public List<Member0_rboardVO> ListWithPaging(Criteria criteria, String subject);

	public void deletemember0_rboard(int m0rseq);
}
