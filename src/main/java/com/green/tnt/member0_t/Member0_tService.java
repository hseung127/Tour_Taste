package com.green.tnt.member0_t;

import java.util.List;


import com.green.tnt.dto.Member0_tVO;

import utils.Criteria;

public interface Member0_tService {

	
	public List<Member0_tVO> getSearchMember0_tList(String key);
	
	public int getCountSearchMember0_tList(String key);
	
	public List<Member0_tVO> getListWithPaging(Criteria criteria, String key);
	
	public void insertMember0_t(Member0_tVO vo);
	
	public void updateMember0_t(Member0_tVO vo);
	
	public void deleteMember0_t(Member0_tVO vo);
	
	public int countMember0_tList(Member0_tVO vo);
	
	public List<Member0_tVO> getM0_tListPaging(Criteria criteria, Member0_tVO vo);

	public Member0_tVO getM0_tDetail(Member0_tVO vo);

}