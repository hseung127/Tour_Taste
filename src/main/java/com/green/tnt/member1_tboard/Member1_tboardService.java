package com.green.tnt.member1_tboard;

import java.util.List;

import com.green.tnt.dto.Member1_tboardVO;

import utils.Criteria;

public interface Member1_tboardService {
	
	Member1_tboardVO getMember1_tboard(int m1tseq);

	public int countMember1_tboard(Criteria criteria);

	public List<Member1_tboardVO> listMember1_tboard(String subject);

	public List<Member1_tboardVO> ListWithPaging(Criteria criteria);
	
	public void insertMember1_tboard(Member1_tboardVO vo);

	public void updateMember1_tboard(Member1_tboardVO vo);
	
	public void deletemember1_tboard(int m1tseq);
	
	public void member1_tboardHit(int m1tseq);
}
