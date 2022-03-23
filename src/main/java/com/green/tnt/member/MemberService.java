package com.green.tnt.member;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.tnt.dto.MemberVO;

public interface MemberService {

	//회원 상세정보 조회
	MemberVO getMember(String id);

	//로그인 처리
	int loginId(MemberVO vo);
	
	//salt값 가져오기
	String getSaltById(MemberVO vo);

	//회원 등록
	void insertMember(MemberVO vo);

	//비동기 아이디 중복 확인
	int idCheck(String id);
	
	// AuthKey 업데이트
	void updateAuthkey(MemberVO vo);
	
	//Authstatus 업데이트
	void updateAuthstatus(MemberVO vo);
	
	//아이디 찾기
	String find_id(HttpServletResponse response, MemberVO vo) throws Exception;
	
	//비밀번호 찾기
	String selectPwd(MemberVO vo);
	
	//임시 비밀번호 업데이트
	void updatePwd(MemberVO vo);
	
	//회원 탈퇴
	void deleteMember(MemberVO vo);
	
	//회원 목록 조회
	List<MemberVO> listMember(String name);
	
	//카카오 사용자 토큰 얻기 
	public String getAccessToken (String authorize_code);
	
	public MemberVO getUserInfo (String access_Token);


	
	public void signout(HttpSession session);

	

	

	



	

	

	

	

	

	
	

	
	
	


}