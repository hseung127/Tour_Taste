
package com.green.tnt.dao;

import java.util.HashMap;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.green.tnt.dto.MemberVO;

import utils.SHA256Util;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//회원 상세정보 조회
	public MemberVO getMember(String id) {
		
		return mybatis.selectOne("mappings.member-mapping.getMember", id);
	}
	
	//로그인 처리
    //id가 존재하지 않을 경우: -1	/	pwd가 틀릴 경우: 0	/	id, pwd가 일치할 경우: 1
	public int loginId(MemberVO vo) {

		int result = -1;	//기본 조회 결과
		
		String pwd_in_db = mybatis.selectOne("mappings.member-mapping.loginId", vo.getId());
		
		if (pwd_in_db == null) {	// id가 없을 경우
			result = -1;	
		} else {					// id가 존재할 경우
			String salt = mybatis.selectOne("mappings.member-mapping.getSaltById", vo.getId());
			String pwd = SHA256Util.getEncrypt(vo.getPwd(), salt);
			
			if (pwd.equals(pwd_in_db)) {
				result = 1;
			} else {
				result = 0;
			}
		}

		return result;
		
	}
	
	public String getSaltById(MemberVO vo) {
		
		return mybatis.selectOne("mappings.member-mapping.getSaltById", vo);
	}
	
	//회원 등록
	public void insertMember(MemberVO vo) {
		
		mybatis.insert("mappings.member-mapping.insertMember", vo);
	}	
	
	//비동기 아이디 중복 확인
    public int idCheck(String id) {
        int cnt = mybatis.selectOne("mappings.member-mapping.idCheck", id);
        return cnt;
    }
	
	//이메일 인증을 위한 AuthKey 업데이트
	public void updateAuthkey(MemberVO vo) {
			
		mybatis.update("mappings.member-mapping.updateAuthkey", vo);
	}
	
	//Authstatus 업데이트
	public void updateAuthstatus(MemberVO vo) {
		
		mybatis.update("mappings.member-mapping.updateAuthstatus", vo);
	}
	
	// 아이디 찾기
	public String find_id(MemberVO vo) throws Exception{
		
		return mybatis.selectOne("mappings.member-mapping.find_id", vo);
	}
	
	//비밀번호 찾기
	public String selectPwd(MemberVO vo) {
		
		return mybatis.selectOne("mappings.member-mapping.selectPwd", vo);
	}
	
	//비밀번호 변경을 위한 임시비밀번호로 업데이트
	public void updatePwd(MemberVO vo) {
		mybatis.update("mappings.member-mapping.updatePwd", vo);
	}
	
	//회원 탈퇴	
	public void deleteMember(MemberVO vo) {

		mybatis.delete("mappings.member-mapping.deleteMember", vo);
	}
	
	
	// 정보 저장
	public void insertKakao(HashMap<String, Object> userInfo) {
		mybatis.insert("mappings.member-mapping.insertKakao",userInfo);
	}

	// 정보 확인
	public MemberVO findKakao(HashMap<String, Object> userInfo) {
		System.out.println("RN:"+userInfo.get("nickname"));
		System.out.println("RE:"+userInfo.get("email"));
		return mybatis.selectOne("mappings.member-mapping.findKakao", userInfo);
	}

	

	
	//회원 목록 조회
	public List<MemberVO> listMember(String name){
		return mybatis.selectOne("mappings.member-mapping.listMember", name);		
	}
	
	

	


}
