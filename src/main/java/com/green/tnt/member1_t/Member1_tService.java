package com.green.tnt.member1_t;

import java.util.List;

import com.green.tnt.dto.Member1_tVO;

import utils.Criteria;

public interface Member1_tService {

	public List<Member1_tVO> getHomeMember1_tList();
	
	public List<Member1_tVO> getSearchMember1_tList(String key);
	
	public int getCountSearchMember1_tList(String key);
	
	public List<Member1_tVO> getListWithPaging(Criteria criteria, String key);
	
	public int countMember1_tList(Member1_tVO vo);
	
	public List<Member1_tVO> getM1_tListPaging(Criteria criteria, Member1_tVO vo);

	public Member1_tVO getM1_tDetail(Member1_tVO vo);

}