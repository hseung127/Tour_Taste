package com.green.tnt.member0_tboard;

import java.util.List;

import com.green.tnt.dto.Member0_tboardVO;

import utils.Criteria;

public interface Member0_tboardService {
	
	Member0_tboardVO getMember0_tboard(int m0tseq);

	public int countMember0_tboard(Criteria criteria);

	public List<Member0_tboardVO> listMember0_tboard(String subject);

	public List<Member0_tboardVO> ListWithPaging(Criteria criteria);

	public void deletemember0_tboard(int m0tseq);
	
	public void member0_tboardHit(int m0tseq);
}
