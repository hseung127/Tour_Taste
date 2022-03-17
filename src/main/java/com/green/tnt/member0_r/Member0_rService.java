package com.green.tnt.member0_r;

import java.util.List;

import com.green.tnt.dto.Member0_rVO;

import utils.Criteria;

public interface Member0_rService {

	public List<Member0_rVO> getHomeMember0_rList();
	
	public List<Member0_rVO> getSearchMember0_rList(String key);
	
	public int getCountSearchMember0_rList(String key);
	
	public List<Member0_rVO> getListWithPaging(Criteria criteria, String key);
	
	public void insertMember0_r(Member0_rVO vo);
	
	public void updateMember0_r(Member0_rVO vo);
	
	public void deleteMember0_r(Member0_rVO vo);
	
	public int countMember0_rList(Member0_rVO vo);
	
	public List<Member0_rVO> getM0_rListPaging(Criteria criteria, Member0_rVO vo);
	
	public Member0_rVO getM0_rDetail(Member0_rVO vo);

}