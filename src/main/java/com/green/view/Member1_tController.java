package com.green.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.tnt.dto.Member1_tVO;
import com.green.tnt.dto.MemberVO;
import com.green.tnt.member1_t.Member1_tService;

import utils.Criteria;
import utils.PageMaker;

@Controller
public class Member1_tController {
	
	@Autowired
	private Member1_tService m1tService;
	
	/*@RequestMapping(value="/worker_tList")
	public String getMember1_tList(Member1_tVO vo, Model model) {
		
		List<Member1_tVO> member1tList = m1tService.getMember1_tList(vo);
		
		
		model.addAttribute("member1tList", member1tList);
		
		return "worker_tList";
	}*/
	
	// 리스트 페이징
	@RequestMapping(value="/worker_tList")
	public String getMember1_tList(Member1_tVO vo, Model model, Criteria criteria, HttpSession session) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		if( loginUser != null ) {
			vo.setId(loginUser.getId());
			model.addAttribute("loginUser", loginUser);
		}
		
		List<Member1_tVO> member1tList = m1tService.getM1_tListPaging(criteria, vo);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		int totalCount = m1tService.countMember1_tList(vo);
		System.out.println("totalCount="+totalCount);
		pageMaker.setTotalCount(totalCount);
		System.out.println("pageMaker="+pageMaker);
		
		
		model.addAttribute("member1tList", member1tList);
		//model.addAttribute("member1tListSize", member1tList.size());
		model.addAttribute("member1tListSize", totalCount);
		model.addAttribute("pageMaker", pageMaker);
		
		
		return "worker_t/worker_tList";
	}
	
	// 상세 정보
	@RequestMapping(value="/worker_tDetail")
	public String worker_tDetail(Member1_tVO vo, Model model) {
		
		Member1_tVO member1_t = m1tService.getM1_tDetail(vo);
		
		model.addAttribute("m1t", member1_t);
		
		return "worker_t/worker_tDetail";
	}
	
	
}
