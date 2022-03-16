package com.green.tnt.member;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.green.tnt.dao.MemberDAO;
import com.green.tnt.dto.MemberVO;


@Service("mss")
public class MemberMailSendService {
	
	@Autowired
	private MemberDAO mDao;
	@Autowired
	private JavaMailSender mailSender;
	private int size; 
	

	//인증키 생성
	private String getKey(int size) {
		this.size = size;
		return getAuthCode();
	}

	//인증코드 난수 발생
	private String getAuthCode() {
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		int num = 0;

	    while(buffer.length() < size) {
	    	num = random.nextInt(10);
	    	buffer.append(num);
	    }

	    return buffer.toString();
	 }

	//인증메일 보내기
	public String sendAuthMail(String id, String email) {

		String authKey = getKey(6);
	
		//인증메일 보내기
		try {
			 MimeMessage msg = mailSender.createMimeMessage();
		     MimeMessageHelper helper = new MimeMessageHelper(msg, "utf-8");
		 
		// 이메일 수신자	
		helper.setTo(email);
		 
		// 이메일 발신자
		helper.setFrom("dlarhkddn@gamil.com");
		 
		// 이메일 제목
		helper.setSubject("회원가입 이메일 인증");
		 			 
		
		// 이메일 본문
		String htmlMsg = new StringBuffer()
				 .append("회원가입 인증 메일입니다." + "<br>"
		+ "아래 링크를 클릭하시면 이메일 인증이 완료됩니다." + "<br>"
		+ "")
		.append("<a href='http://172.30.1.36:8181/biz/emailConfirm?id=")
		.append(id)
		.append("&email=")
		.append(email)
		.append("&authKey=")
		.append(authKey)
		.append("'>인증 확인</a>")
		.toString();

		helper.setText(htmlMsg, true);
		             
		mailSender.send(msg);
					 
					 
		
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		 
		return authKey;
	}
	
	
	//임시비밀번호 생성
	private String getPwd(int size) {
		this.size = size;
		return getTempPwd();
	}

	//임시 비밀번호 난수 발생
	private String getTempPwd() {
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		int num = 0;

	    while(buffer.length() < size) {
	    	num = random.nextInt(10);
	    	buffer.append(num);
	    }

	    return buffer.toString();
	}
	
	//임시 비밀번호 보내기
	public String sendPwdMail(String id, String email) {
	
		String tempPwd = getPwd(8);
		
		
		//임시 비밀번호 보내기
		try {
			 MimeMessage msg = mailSender.createMimeMessage();
		     MimeMessageHelper helper = new MimeMessageHelper(msg, "utf-8");
		 
		// 이메일 수신자	
		helper.setTo(email);
		// 이메일 발신자
		helper.setFrom("dlarhkddn@gamil.com");
		// 이메일 제목
		helper.setSubject("임시 비밀번호 메일입니다.");		
		// 이메일 본문
		String htmlMsg = new StringBuffer()
				 .append("임시 비밀번호 메일입니다." + "<br>"
						 + "로그인 후 비밀번호를 변경하여 사용해주세요." + "<br>")
				 .append(tempPwd)
				 .toString();

		helper.setText(htmlMsg, true);		             
		mailSender.send(msg);
		
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return tempPwd;
		 
	}
}
