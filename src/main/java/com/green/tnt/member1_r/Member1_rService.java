package com.green.tnt.member1_r;

import java.util.List;

import com.green.tnt.dto.Member1_rVO;

import utils.Criteria;

public interface Member1_rService {

	public List<Member1_rVO> getHomeMember1_rList();
	
	public List<Member1_rVO> getSearchMember1_rList(String key);
	
	public int getCountSearchMember1_rList(String key);
	
	public List<Member1_rVO> getListWithPaging(Criteria criteria, String key);
	
	public int countMember1_rList(Member1_rVO vo);
	
	public List<Member1_rVO> getM1_rListPaging(Criteria criteria, Member1_rVO vo);

	public Member1_rVO getM1_rDetail(Member1_rVO vo);

}