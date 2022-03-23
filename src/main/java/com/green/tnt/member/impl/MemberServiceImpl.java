package com.green.tnt.member.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.green.tnt.dao.MemberDAO;
import com.green.tnt.dto.MemberVO;
import com.green.tnt.member.MemberService;

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
	
	public String getAccessToken (String authorize_code) {
		String access_Token = "";
		String refresh_Token = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=212d2c67f280df58011ee3c0a68d211f"); //본인이 발급받은 key
			sb.append("&redirect_uri=http://localhost:8181/biz/kakao_login"); // 본인이 설정한 주소
			sb.append("&code=" + authorize_code);
			bw.write(sb.toString());
			bw.flush();
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";
			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);
			
			 //Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);
            
			access_Token = element.getAsJsonObject().get("access_token").getAsString();
			refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
			System.out.println("access_token : " + access_Token);
			System.out.println("refresh_token : " + refresh_Token);
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return access_Token;
	}
	
	
	  public MemberVO getUserInfo (String access_Token) {
	
	      //    요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
	      HashMap<String, Object> userInfo = new HashMap<>();
	      String reqURL = "https://kapi.kakao.com/v2/user/me";
	      try {
	          URL url = new URL(reqURL);
	          HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	          conn.setRequestMethod("GET");
	
	          //    요청에 필요한 Header에 포함될 내용
	          conn.setRequestProperty("Authorization", "Bearer " + access_Token);
	
	          int responseCode = conn.getResponseCode();
	          System.out.println("responseCode : " + responseCode);
	
	          BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	
	          String line = "";
	          String result = "";
	
	          while ((line = br.readLine()) != null) {
	              result += line;
	          }
	          System.out.println("response body : " + result);
	
	          JsonParser parser = new JsonParser();
	          JsonElement element = parser.parse(result);
	
	          JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
	          JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
	
	          String nickname = properties.getAsJsonObject().get("nickname").getAsString();
	          String email = kakao_account.getAsJsonObject().get("email").getAsString();
	
	          userInfo.put("nickname", nickname);
	          userInfo.put("email", email);
	
	      } catch (IOException e) {
	          
	          e.printStackTrace();
	      }
	      
	   // catch 아래 코드 추가.
			MemberVO result = mDao.findKakao(userInfo);
			// 위 코드는 먼저 정보가 저장되있는지 확인하는 코드.
			System.out.println("S:" + result);
			if(result==null) {
			// result가 null이면 정보가 저장이 안되있는거므로 정보를 저장.
				mDao.insertKakao(userInfo);
				// 위 코드가 정보를 저장하기 위해 Repository로 보내는 코드임.
				return mDao.findKakao(userInfo);
				// 위 코드는 정보 저장 후 컨트롤러에 정보를 보내는 코드임.
				//  result를 리턴으로 보내면 null이 리턴되므로 위 코드를 사용.
			} else {
				return result;
				// 정보가 이미 있기 때문에 result를 리턴함.
			}
	  }

	
	@Override
	public void signout(HttpSession session) {
		session.invalidate();
		
	}


}
