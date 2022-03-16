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
	

	//����Ű ����
	private String getKey(int size) {
		this.size = size;
		return getAuthCode();
	}

	//�����ڵ� ���� �߻�
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

	//�������� ������
	public String sendAuthMail(String id, String email) {

		String authKey = getKey(6);
	
		//�������� ������
		try {
			 MimeMessage msg = mailSender.createMimeMessage();
		     MimeMessageHelper helper = new MimeMessageHelper(msg, "utf-8");
		 
		// �̸��� ������	
		helper.setTo(email);
		 
		// �̸��� �߽���
		helper.setFrom("dlarhkddn@gamil.com");
		 
		// �̸��� ����
		helper.setSubject("ȸ������ �̸��� ����");
		 			 
		
		// �̸��� ����
		String htmlMsg = new StringBuffer()
				 .append("ȸ������ ���� �����Դϴ�." + "<br>"
		+ "�Ʒ� ��ũ�� Ŭ���Ͻø� �̸��� ������ �Ϸ�˴ϴ�." + "<br>"
		+ "")
		.append("<a href='http://172.30.1.36:8181/biz/emailConfirm?id=")
		.append(id)
		.append("&email=")
		.append(email)
		.append("&authKey=")
		.append(authKey)
		.append("'>���� Ȯ��</a>")
		.toString();

		helper.setText(htmlMsg, true);
		             
		mailSender.send(msg);
					 
					 
		
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		 
		return authKey;
	}
	
	
	//�ӽú�й�ȣ ����
	private String getPwd(int size) {
		this.size = size;
		return getTempPwd();
	}

	//�ӽ� ��й�ȣ ���� �߻�
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
	
	//�ӽ� ��й�ȣ ������
	public String sendPwdMail(String id, String email) {
	
		String tempPwd = getPwd(8);
		
		
		//�ӽ� ��й�ȣ ������
		try {
			 MimeMessage msg = mailSender.createMimeMessage();
		     MimeMessageHelper helper = new MimeMessageHelper(msg, "utf-8");
		 
		// �̸��� ������	
		helper.setTo(email);
		// �̸��� �߽���
		helper.setFrom("dlarhkddn@gamil.com");
		// �̸��� ����
		helper.setSubject("�ӽ� ��й�ȣ �����Դϴ�.");		
		// �̸��� ����
		String htmlMsg = new StringBuffer()
				 .append("�ӽ� ��й�ȣ �����Դϴ�." + "<br>"
						 + "�α��� �� ��й�ȣ�� �����Ͽ� ������ּ���." + "<br>")
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
