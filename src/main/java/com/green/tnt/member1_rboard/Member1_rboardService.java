package com.green.tnt.member1_rboard;

import java.util.List;

import com.green.tnt.dto.Member1_rboardVO;

import utils.Criteria;

public interface Member1_rboardService {
	
	Member1_rboardVO getMember1_rboard(Member1_rboardVO vo);

	public int countMember1_rboard(String subject);

	public List<Member1_rboardVO> listMember1_rboard(String subject);

	public List<Member1_rboardVO> ListWithPaging(Criteria criteria, String subject);
	
	public void insertMember1_rboard(Member1_rboardVO vo);

	public void updateMember1_rboard(Member1_rboardVO vo);

	public void deletemember1_rboard(int m1rseq);
}
