package com.green.tnt.member;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.tnt.dto.MemberVO;

public interface MemberService {

	//ȸ�� ������ ��ȸ
	MemberVO getMember(String id);

	//�α��� ó��
	int loginId(MemberVO vo);
	
	//salt�� ��������
	String getSaltById(MemberVO vo);

	//ȸ�� ���
	void insertMember(MemberVO vo);

	//�񵿱� ���̵� �ߺ� Ȯ��
	int idCheck(String id);
	
	// AuthKey ������Ʈ
	void updateAuthkey(MemberVO vo);
	
	//Authstatus ������Ʈ
	void updateAuthstatus(MemberVO vo);
	
	//���̵� ã��
	String find_id(HttpServletResponse response, MemberVO vo) throws Exception;
	
	//��й�ȣ ã��
	String selectPwd(MemberVO vo);
	
	//�ӽ� ��й�ȣ ������Ʈ
	void updatePwd(MemberVO vo);
	
	

	
	//ȸ�� ��� ��ȸ
	List<MemberVO> listMember(String name);
	
	//īī��
	String getReturnAccessToken(String code);

	

	
	public void signout(HttpSession session);


	

	

	

	

	

	
	

	
	
	


}