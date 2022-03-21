package com.green.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.tnt.dto.Member1_rVO;
import com.green.tnt.dto.Member1_tVO;
import com.green.tnt.dto.MemberVO;
import com.green.tnt.member1_r.Member1_rService;
import com.green.tnt.member1_t.Member1_tService;

import utils.Criteria;
import utils.PageMaker;

@Controller
public class Member1_rController {
	
	@Autowired
	private Member1_rService m1rService;
	
	/*@RequestMapping(value="/worker_tList")
	public String getMember1_tList(Member1_tVO vo, Model model) {
		
		List<Member1_tVO> member1tList = m1tService.getMember1_tList(vo);
		
		
		model.addAttribute("member1tList", member1tList);
		
		return "worker_tList";
	}*/
	
	@RequestMapping(value="/worker_rList")
	public String getMember1_rList(Member1_rVO vo, Model model, Criteria criteria, HttpSession session) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		if( loginUser != null ) {
			vo.setId(loginUser.getId());
			model.addAttribute("loginUser", loginUser);
		}
		
		List<Member1_rVO> member1rList = m1rService.getM1_rListPaging(criteria, vo);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		int totalCount = m1rService.countMember1_rList(vo);
		System.out.println("totalCount="+totalCount);
		pageMaker.setTotalCount(totalCount);
		System.out.println("pageMaker="+pageMaker);
		
		
		model.addAttribute("member1rList", member1rList);
		//model.addAttribute("member1rListSize", member1rList.size());
		model.addAttribute("member1rListSize", totalCount);
		model.addAttribute("pageMaker", pageMaker);
		
		return "worker_r/worker_rList";
	}
	
	// 상세 정보
	@RequestMapping(value="/worker_rDetail")
	public String worker_rDetail(Member1_rVO vo, Model model) {
		
		Member1_rVO member1_r = m1rService.getM1_rDetail(vo);
		
		model.addAttribute("m1r", member1_r);
		
		return "worker_r/worker_rDetail";
	}
}
