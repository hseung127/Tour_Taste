package com.green.view;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.green.tnt.dto.MemberVO;
import com.green.tnt.member.MemberService;

import utils.SHA256Util;





@Controller
@SessionAttributes("loginUser")
public class MypageController {

	@Autowired //@Autowired�� �ν��Ͻ��� �������� �ʾƵ� �������� �ڵ����� �ν��Ͻ��� �������ִ� ���
	private MemberService memberService;
	
	//���� ������ �̵�
	@GetMapping(value="/mypage_form")
	public String mypageView() {
		
		return "mypage/mypage_main";
	}
	
	//��й�ȣ ���� ������ �̵�
	@GetMapping(value="/modify_pwd_form")
	public String modifyPwdView() {
		
		return "mypage/modify_pwd";
	}
	
	@PostMapping(value="modify_pwd")
	public void modifyPwd(@RequestParam (value="cur_pwd") String cur_pwd,
			      @RequestParam(value="new_pwd") String new_pwd,
	                                   HttpSession session,
	                                   SessionStatus status,
	                                   HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
	    MemberVO vo = (MemberVO) session.getAttribute("loginUser");
	    String db_pwd = memberService.selectPwd(vo);	//���̺��� pwd�� ������
	    String salt = memberService.getSaltById(vo);	//���̺��� salt�� ������
	    String result = SHA256Util.getEncrypt(cur_pwd, salt);	//���� ��й�ȣ�� ���̺��� salt�� ����
	    
	    if (result.equals(db_pwd)) {
	    	//���� ��й�ȣ�� ���̺��� salt�� ���� ���� ���̺��� pwd�� ��ġ�ϸ�
	    	//�ٽ� ���ο� salt�� �����Ѵ�
	    	String new_salt = SHA256Util.generateSalt();
	    	
	    	//���ο� ��й�ȣ�� ���ο� salt�� ����
			String pwd = SHA256Util.getEncrypt(new_pwd, new_salt);
			
			// ���ο� ��й�ȣ�� ���ο� salt�� ���̺� ������Ʈ
			vo.setPwd(pwd);
	        vo.setSalt(new_salt);
	    	
	        memberService.updatePwd(vo);
	        status.setComplete();
	        out.println("<script>alert('��й�ȣ�� ����Ǿ� �α����� �����Ǿ����ϴ�."
	        		+ "\\n"
	        		+ "���ο� ��й�ȣ�� �ٽ� �α������ּ���.');"
					+ " location.href='login_form';</script>");
			out.flush();
			
	    } else {
	    	
	    	out.println("<script>alert('���� ��й�ȣ�� �߸� �Է��Ͽ����ϴ�."
	    			+ "\\n"
	        		+ "�ٽ� Ȯ�����ּ���.');"
					+ " history.go(-1);</script>");
			out.flush();
	    	
	    }
	    
	}



}













