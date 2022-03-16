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

	@Autowired //@Autowired는 인스턴스를 생성하지 않아도 스프링이 자동으로 인스턴스를 주입해주는 기능
	private MemberService memberService;
	@Autowired
	private MemberMailSendService mss;	
	@Autowired
	private MemberDAO mDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//약관동의 페이지 이동
	@GetMapping(value="/contract_form")
	public String contractView() {
		
		return "member/contract";
	}
		
	//회원가입 페이지 이동
	@PostMapping(value="/join_form")
	public String joinView() {
		
		return "member/join";
	}
	
	//아이디 중복 체크
    @PostMapping(value="/idCheck")
    @ResponseBody
    public int idCheck(@RequestParam("id") String id){
        int cnt = memberService.idCheck(id);
        return cnt;
    }

	//회원가입 처리
	@PostMapping(value="/join")	//포스트로 가져옴
	public String joinAction(MemberVO vo) {
			
		String salt = SHA256Util.generateSalt();
		String pwd = SHA256Util.getEncrypt(vo.getPwd(), salt);
		
		vo.setPwd(pwd);
        vo.setSalt(salt);
		
		//DB에 회원 정보 업데이트
 		memberService.insertMember(vo);
 		
		//이메일 인증을 위한 임의의 authKey 생성 & 이메일 발송
        String authKey = mss.sendAuthMail(vo.getId(), vo.getEmail());
        vo.setAuthkey(authKey);
        
        //DB에 생성한 임의의 authKey 업데이트
		memberService.updateAuthkey(vo);
		
		return "member/login";
	}
	
	//이메일 인증 확인시 Authstatus 1로 변경
	@GetMapping("/emailConfirm")
		public String emailConfirm(MemberVO vo, Model model) throws Exception {
		// authstatus 권한 상태 1로 변경
		memberService.updateAuthstatus(vo);
		
		model.addAttribute("vo", vo);

		return "member/emailConfirm";
	}
	
	//로그인 버튼 -> 로그인 화면으로 이동
	@GetMapping(value="/login_form")
	public String loginView() {
		
		return "member/login";
	}
	
	//로그인 처리
	@PostMapping(value="/login")
	public String loginAction(MemberVO vo, Model model) {
		MemberVO loginUser = null;
		
		int result = memberService.loginId(vo);		
		
		if (result == 1) { // 사용자 인증 성공
			// 사용자 정보를 조회하여 Session 객체에 저장
			loginUser = memberService.getMember(vo.getId());
			
			// @SessionAttributes로 지정하여 세션에도 저장됨.
			//Model addAttribute(String name, Object value)
			//value 객체를 name 이름으로 추가한다. 즉, "loginUser" 에는  loginUser 값이 들어간다.
			model.addAttribute("loginUser", loginUser); 
			
			return "redirect:/index";	
			
			} else if(result == -1){
				model.addAttribute("message", "아이디를 잘못 입력하였습니다.");
				
				return "member/login";
				
			} else {
				model.addAttribute("message", "비밀번호를 잘못 입력하였습니다.");
				
				return "member/login";
				
		}
	}
	
	//로그아웃 처리
	@GetMapping(value="/logout")
	public String logout(SessionStatus status) {
		
		status.setComplete();    // 현재 세션을 종료
		
		return "redirect:/index";
	}
	
	//아이디 찾기 페이지 이동
	@GetMapping(value="/find_id_form")
	public String find_id_view() throws Exception{
		
		return "member/find_id_form";
	}
	
	// 아이디 찾기
	@PostMapping(value="/find_id")
	public String find_id(HttpServletResponse response, MemberVO vo, Model md) throws Exception{
		
		String result = memberService.find_id(response, vo);
		
		md.addAttribute("id", memberService.find_id(response, vo));
		
		return "member/find_id";
	}
	
	//비밀번호 찾기 페이지 이동
	@GetMapping(value="/find_pwd_form")
	public String find_pw_form() throws Exception{
		
		return "/member/find_pwd_form";
	}
	
	// 비밀번호 찾기
	@PostMapping(value="/find_pwd")
	public String find_pw(HttpServletResponse response, MemberVO vo, Model model) throws Exception {		
		
		//비밀번호 찾기(아이디와 이메일이 맞으면 true)
		String result = memberService.selectPwd(vo);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(result != null) {
			//임시비밀번호 메일 보내기
			String tempPwd = mss.sendPwdMail(vo.getId(), vo.getEmail());	        
			vo.setPwd(tempPwd);
	        
	        //임시 비밀번호 암호화
			String salt = SHA256Util.generateSalt();
			String pwd = SHA256Util.getEncrypt(vo.getPwd(), salt);
			
			vo.setPwd(pwd);
	        vo.setSalt(salt);
	 		
	        //DB에 암호화한 임시 비밀번호 업데이트
			memberService.updatePwd(vo);
			
			out.println("<script>alert('해당 이메일로 임시 비밀번호를 발송하였습니다.');"
					+ " location.href='login_form';</script>");
			out.flush();
			
			return result;
									
		} else {
			
			model.addAttribute("message", "존재하지 않는 계정입니다.");
			
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
			
			System.out.println("동작");
			session.setAttribute("member", email);
			ModelAndView mav = new ModelAndView("loginOK");
			return mav;
		}
}













