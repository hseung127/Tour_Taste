package com.green.view;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.green.tnt.dto.MemberVO;
import com.green.tnt.member.MemberService;

import utils.SHA256Util;





@Controller
@SessionAttributes("loginUser")
public class MypageController {

	@Autowired //@Autowired는 인스턴스를 생성하지 않아도 스프링이 자동으로 인스턴스를 주입해주는 기능
	private MemberService memberService;
	
	//마이 페이지 이동
	@GetMapping(value="/mypage_form")
	public String mypageView() {
		
		return "mypage/mypage_main";
	}
	
	//비밀번호 변경 페이지 이동
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
	    String db_pwd = memberService.selectPwd(vo);	//테이블의 pwd를 가져옴
	    String salt = memberService.getSaltById(vo);	//테이블의 salt를 가져옴
	    String result = SHA256Util.getEncrypt(cur_pwd, salt);	//현재 비밀번호와 테이블의 salt를 섞음
	    
	    if (result.equals(db_pwd)) {
	    	//현재 비밀번호와 테이블의 salt를 섞은 값과 테이블의 pwd가 일치하면
	    	//다시 새로운 salt를 생성한다
	    	String new_salt = SHA256Util.generateSalt();
	    	
	    	//새로운 비밀번호와 새로운 salt를 섞음
			String pwd = SHA256Util.getEncrypt(new_pwd, new_salt);
			
			// 새로운 비밀번호와 새로운 salt를 테이블에 업데이트
			vo.setPwd(pwd);
	        vo.setSalt(new_salt);
	    	
	        memberService.updatePwd(vo);
	        status.setComplete();
	        out.println("<script>alert('비밀번호가 변경되어 로그인이 해제되었습니다."
	        		+ "\\n"
	        		+ "새로운 비밀번호로 다시 로그인해주세요.');"
					+ " location.href='login_form';</script>");
			out.flush();
			
	    } else {
	    	
	    	out.println("<script>alert('현재 비밀번호를 잘못 입력하였습니다."
	    			+ "\\n"
	        		+ "다시 확인해주세요.');"
					+ " history.go(-1);</script>");
			out.flush();
	    	
	    }
	    
	}


}













