package com.green.tnt.member.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.green.tnt.dao.MemberDAO;
import com.green.tnt.dto.MemberVO;
import com.green.tnt.member.MemberService;

import utils.SHA256Util;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO mDao;
	@Autowired
	private JavaMailSender mailSender;
	
	
	@Override
	public MemberVO getMember(String id) {
		
		return mDao.getMember(id);
	}

	@Override
	public int loginId(MemberVO vo) {
		
		return mDao.loginId(vo);
	}
	
	@Override
	public String getSaltById(MemberVO vo) {
		
		return mDao.getSaltById(vo);
	}
	
	@Override
	public void insertMember(MemberVO vo) {
		
		mDao.insertMember(vo);
	}
	
	//비동기 아이디 중복 확인
	@Override
    public int idCheck(String id) {
        int cnt = mDao.idCheck(id);
        return cnt;
    }
	
	@Override
	public void updateAuthkey(MemberVO vo) {
		
		mDao.updateAuthkey(vo);
	}

	@Override
	public void updateAuthstatus(MemberVO vo) {

		mDao.updateAuthstatus(vo);
	}
	
	@Override
	public String find_id(HttpServletResponse response, MemberVO vo) throws Exception {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = mDao.find_id(vo);
		
		if (id == null) {
			out.println("<script>");
			out.println("alert('가입된 아이디가 없습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		} else {
			return id;
		}
	}
	
	@Override
	public String selectPwd(MemberVO vo) {
		
		return mDao.selectPwd(vo);
	}

	@Override
	public void updatePwd(MemberVO vo) {
		
		mDao.updatePwd(vo);
	}
	
	@Override
	public void deleteMember(MemberVO vo) {
		
		mDao.deleteMember(vo);
	}
	
	
	
	@Override
	public List<MemberVO> listMember(String name) {
		
		return mDao.listMember(name);
	}
	
	@Override
    public String getReturnAccessToken(String code) {
         String access_token = "";
         String refresh_token = "";
         String reqURL = "https://kauth.kakao.com/oauth/token";
        
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
             //HttpURLConnection 설정 값 셋팅
             conn.setRequestMethod("POST");
             conn.setDoOutput(true);
             
             
             // buffer 스트림 객체 값 셋팅 후 요청
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
             StringBuilder sb = new StringBuilder();
             sb.append("grant_type=authorization_code");
             sb.append("&client_id=[내 애플리케이션 Key 값]");  //앱 KEY VALUE
             sb.append("&redirect_uri=http://localhost:8080/kakao_callback"); // 앱 CALLBACK 경로
             sb.append("&code=" + code);
             bw.write(sb.toString());
             bw.flush();
             
             //  RETURN 값 result 변수에 저장
             BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
             String br_line = "";
             String result = "";
 
             while ((br_line = br.readLine()) != null) {
                 result += br_line;
             }
 
             JsonParser parser = new JsonParser();
             JsonElement element = parser.parse(result);
 
             
             // 토큰 값 저장 및 리턴
             access_token = element.getAsJsonObject().get("access_token").getAsString();
             refresh_token = element.getAsJsonObject().get("refresh_token").getAsString();
 
             br.close();
             bw.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
 
         return access_token;
     }

	
	@Override
	public void signout(HttpSession session) {
		session.invalidate();
		
	}

}
