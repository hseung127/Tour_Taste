package com.green.view;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.green.tnt.dao.MemberDAO;
import com.green.tnt.dto.MemberVO;
import com.green.tnt.member.MemberMailSendService;
import com.green.tnt.member.MemberService;

import utils.SHA256Util;





@Controller
@SessionAttributes("loginUser")
public class MemberController {

	@Autowired //@Autowired�� �ν��Ͻ��� �������� �ʾƵ� �������� �ڵ����� �ν��Ͻ��� �������ִ� ���
	private MemberService memberService;
	@Autowired
	private MemberMailSendService mss;	
	@Autowired
	private MemberDAO mDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//������� ������ �̵�
	@GetMapping(value="/contract_form")
	public String contractView() {
		
		return "member/contract";
	}
		
	//ȸ������ ������ �̵�
	@PostMapping(value="/join_form")
	public String joinView() {
		
		return "member/join";
	}
	
	//���̵� �ߺ� üũ
    @PostMapping(value="/idCheck")
    @ResponseBody
    public int idCheck(@RequestParam("id") String id){
        int cnt = memberService.idCheck(id);
        return cnt;
    }

	//ȸ������ ó��
	@PostMapping(value="/join")	//����Ʈ�� ������
	public String joinAction(MemberVO vo) {
			
		String salt = SHA256Util.generateSalt();
		String pwd = SHA256Util.getEncrypt(vo.getPwd(), salt);
		
		vo.setPwd(pwd);
        vo.setSalt(salt);
		
		//DB�� ȸ�� ���� ������Ʈ
 		memberService.insertMember(vo);
 		
		//�̸��� ������ ���� ������ authKey ���� & �̸��� �߼�
        String authKey = mss.sendAuthMail(vo.getId(), vo.getEmail());
        vo.setAuthkey(authKey);
        
        //DB�� ������ ������ authKey ������Ʈ
		memberService.updateAuthkey(vo);
		
		return "member/login";
	}
	
	//�̸��� ���� Ȯ�ν� Authstatus 1�� ����
	@GetMapping("/emailConfirm")
		public String emailConfirm(MemberVO vo, Model model) throws Exception {
		// authstatus ���� ���� 1�� ����
		memberService.updateAuthstatus(vo);
		
		model.addAttribute("vo", vo);

		return "member/emailConfirm";
	}
	
	//�α��� ��ư -> �α��� ȭ������ �̵�
	@GetMapping(value="/login_form")
	public String loginView() {
		
		return "member/login";
	}
	
	//�α��� ó��
	@PostMapping(value="/login")
	public String loginAction(MemberVO vo, Model model) {
		MemberVO loginUser = null;
		
		int result = memberService.loginId(vo);		
		
		if (result == 1) { // ����� ���� ����
			// ����� ������ ��ȸ�Ͽ� Session ��ü�� ����
			loginUser = memberService.getMember(vo.getId());
			
			// @SessionAttributes�� �����Ͽ� ���ǿ��� �����.
			//Model addAttribute(String name, Object value)
			//value ��ü�� name �̸����� �߰��Ѵ�. ��, "loginUser" ����  loginUser ���� ����.
			model.addAttribute("loginUser", loginUser); 
			
			return "redirect:/index";	
			
			} else if(result == -1){
				model.addAttribute("message", "���̵� �߸� �Է��Ͽ����ϴ�.");
				
				return "member/login";
				
			} else {
				model.addAttribute("message", "��й�ȣ�� �߸� �Է��Ͽ����ϴ�.");
				
				return "member/login";
				
		}
	}
	
	//�α׾ƿ� ó��
	@GetMapping(value="/logout")
	public String logout(SessionStatus status) {
		
		status.setComplete();    // ���� ������ ����
		
		return "redirect:/index";
	}
	
	//���̵� ã�� ������ �̵�
	@GetMapping(value="/find_id_form")
	public String find_id_view() throws Exception{
		
		return "member/find_id_form";
	}
	
	// ���̵� ã��
	@PostMapping(value="/find_id")
	public String find_id(HttpServletResponse response, MemberVO vo, Model md) throws Exception{
		
		String result = memberService.find_id(response, vo);
		
		md.addAttribute("id", memberService.find_id(response, vo));
		
		return "member/find_id";
	}
	
	//��й�ȣ ã�� ������ �̵�
	@GetMapping(value="/find_pwd_form")
	public String find_pw_form() throws Exception{
		
		return "/member/find_pwd_form";
	}
	
	// ��й�ȣ ã��
	@PostMapping(value="/find_pwd")
	public String find_pw(HttpServletResponse response, MemberVO vo, Model model) throws Exception {		
		
		//��й�ȣ ã��(���̵�� �̸����� ������ true)
		String result = memberService.selectPwd(vo);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(result != null) {
			//�ӽú�й�ȣ ���� ������
			String tempPwd = mss.sendPwdMail(vo.getId(), vo.getEmail());	        
			vo.setPwd(tempPwd);
	        
	        //�ӽ� ��й�ȣ ��ȣȭ
			String salt = SHA256Util.generateSalt();
			String pwd = SHA256Util.getEncrypt(vo.getPwd(), salt);
			
			vo.setPwd(pwd);
	        vo.setSalt(salt);
	 		
	        //DB�� ��ȣȭ�� �ӽ� ��й�ȣ ������Ʈ
			memberService.updatePwd(vo);
			
			out.println("<script>alert('�ش� �̸��Ϸ� �ӽ� ��й�ȣ�� �߼��Ͽ����ϴ�.');"
					+ " location.href='login_form';</script>");
			out.flush();
			
			return result;
									
		} else {
			
			model.addAttribute("message", "�������� �ʴ� �����Դϴ�.");
			
			return "member/find_pwd_form";
		}
		
	}
	



	
	

	
	
	
	//TODO
		@RequestMapping(value="/kakao_login")
	    public String kakaoLogin() {
	        StringBuffer loginUrl = new StringBuffer();
	        loginUrl.append("https://kauth.kakao.com/oauth/authorize?client_id=");
	        loginUrl.append("212d2c67f280df58011ee3c0a68d211f"); 
	        loginUrl.append("&redirect_uri=");
	        loginUrl.append("http://localhost:8181/biz/index"); 
	        loginUrl.append("&response_type=code");
	        
	        return "redirect:"+loginUrl.toString();
	    }
		
		@RequestMapping("/KakaLoginOK/{email}")
		public ModelAndView loginOK(@PathVariable String email, Model model, HttpSession session) {
			
			System.out.println("����");
			session.setAttribute("member", email);
			ModelAndView mav = new ModelAndView("loginOK");
			return mav;
		}
}













