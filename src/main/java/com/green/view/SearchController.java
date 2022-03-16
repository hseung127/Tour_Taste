package com.green.view;

import java.util.List;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.tnt.dto.Member0_rVO;
import com.green.tnt.dto.Member0_tVO;
import com.green.tnt.dto.Member1_rVO;
import com.green.tnt.dto.Member1_tVO;
import com.green.tnt.member0_r.Member0_rService;
import com.green.tnt.member0_t.Member0_tService;
import com.green.tnt.member1_r.Member1_rService;
import com.green.tnt.member1_t.Member1_tService;

import utils.Criteria;
import utils.PageMaker;

@Controller
public class SearchController {

	@Autowired
	private Member1_tService m1tService;
	@Autowired
	private Member1_rService m1rService;
	@Autowired
	private Member0_tService m0tService;
	@Autowired
	private Member0_rService m0rService;
	
	
	@GetMapping(value="/search")
	public String searchM1tAction(@RequestParam("key") String key, Model model ) {
		
		List<Member0_tVO> searchMember0_tList = m0tService.getSearchMember0_tList(key);
		int m0tTotalCount = m0tService.getCountSearchMember0_tList(key);
		model.addAttribute("searchM0tList", searchMember0_tList);
		model.addAttribute("searchM0tListSize", m0tTotalCount);
		System.out.println("searchM0tList=>"+searchMember0_tList);
		
		List<Member0_rVO> searchMember0_rList = m0rService.getSearchMember0_rList(key);
		int m0rTotalCount = m0rService.getCountSearchMember0_rList(key);
		model.addAttribute("searchM0rList", searchMember0_rList);
		model.addAttribute("searchM0rListSize", m0rTotalCount);
		System.out.println("searchM0rList=>"+searchMember0_rList);
		
		List<Member1_tVO> searchMember1_tList = m1tService.getSearchMember1_tList(key);
		int m1tTotalCount = m1tService.getCountSearchMember1_tList(key);
		model.addAttribute("searchM1tList", searchMember1_tList);
		model.addAttribute("searchM1tListSize", m1tTotalCount);
		System.out.println("searchM1tList=>"+searchMember1_tList);
		
		List<Member1_rVO> searchMember1_rList = m1rService.getSearchMember1_rList(key);
		int m1rTotalCount = m1rService.getCountSearchMember1_rList(key);
		model.addAttribute("searchM1rList", searchMember1_rList);
		model.addAttribute("searchM1rListSize", m1rTotalCount);
		System.out.println("searchM1rList=>"+searchMember1_rList);
		
		model.addAttribute("searchKey", key);
		System.out.println(key);
	
		return "search/search";
	}
	
	
	@GetMapping(value="/searchM0tList")
	public String searchM0tListAction(/* HttpServletRequest request, */@RequestParam("key") String key, Criteria criteria, Model model ) {
		
		//String key = request.getParameter("key");
		// 화면에 표시할 페이지버튼 정보 설정
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);  // 현재 페이지와 페이지당 항목 수 정보 설정
		int totalCount = m0tService.getCountSearchMember0_tList(key);
		pageMaker.setTotalCount(totalCount); // 정체 상품목록 갯수 설정 및 페이지 정보 초기화
		System.out.println("[Member0_tList] pageMaker="+pageMaker);

		List<Member0_tVO> searchMember0_tList = m0tService.getListWithPaging(criteria,key);

		model.addAttribute("searchM0tList", searchMember0_tList);
		model.addAttribute("searchM0tListSize", totalCount);
		model.addAttribute("pageMaker", pageMaker);
		
		model.addAttribute("searchKey", key);
		
		System.out.println("searchM0tList=>"+searchMember0_tList);
		System.out.println("searchM0tListSize=>"+totalCount);
		System.out.println("key=>"+key);
	
		return "search/m0tSearchList";
	}
	
	
	@GetMapping(value="/searchM0rList")
	public String searchM0rListAction(/* HttpServletRequest request, */@RequestParam("key") String key, Criteria criteria, Model model ) {
		
		//String key = request.getParameter("key");
		// 화면에 표시할 페이지버튼 정보 설정
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);  // 현재 페이지와 페이지당 항목 수 정보 설정
		int totalCount = m0rService.getCountSearchMember0_rList(key);
		pageMaker.setTotalCount(totalCount); // 정체 상품목록 갯수 설정 및 페이지 정보 초기화
		System.out.println("[Member0_rList] pageMaker="+pageMaker);

		List<Member0_rVO> searchMember0_rList = m0rService.getListWithPaging(criteria,key);

		model.addAttribute("searchM0rList", searchMember0_rList);
		model.addAttribute("searchM0rListSize", totalCount);
		model.addAttribute("pageMaker", pageMaker);
		
		model.addAttribute("searchKey", key);
		
		System.out.println("searchM0rList=>"+searchMember0_rList);
		System.out.println("searchM0rListSize=>"+totalCount);
		System.out.println("key=>"+key);
		
		
	
		return "search/m0rSearchList";
	}
	
	
	@GetMapping(value="/searchM1tList")
	public String searchM1tListAction(/* HttpServletRequest request, */@RequestParam("key") String key, Criteria criteria, Model model ) {
		
		//String key = request.getParameter("key");
		// 화면에 표시할 페이지버튼 정보 설정
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);  // 현재 페이지와 페이지당 항목 수 정보 설정
		int totalCount = m1tService.getCountSearchMember1_tList(key);
		pageMaker.setTotalCount(totalCount); // 정체 상품목록 갯수 설정 및 페이지 정보 초기화
		System.out.println("[Member1_tList] pageMaker="+pageMaker);

		List<Member1_tVO> searchMember1_tList = m1tService.getListWithPaging(criteria,key);

		model.addAttribute("searchM1tList", searchMember1_tList);
		model.addAttribute("searchM1tListSize", totalCount);
		model.addAttribute("pageMaker", pageMaker);
		
		model.addAttribute("searchKey", key);
		
		System.out.println("searchM1tList="+searchMember1_tList);
		System.out.println("searchM1tListSize="+totalCount);
		System.out.println("key=>"+key);
	
		return "search/m1tSearchList";
	}
	
	
	@GetMapping(value="/searchM1rList")
	public String searchM1rListAction(/* HttpServletRequest request, */@RequestParam("key") String key, Criteria criteria, Model model ) {
		
		//String key = request.getParameter("key");
		// 화면에 표시할 페이지버튼 정보 설정
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);  // 현재 페이지와 페이지당 항목 수 정보 설정
		int totalCount = m1rService.getCountSearchMember1_rList(key);
		pageMaker.setTotalCount(totalCount); // 정체 상품목록 갯수 설정 및 페이지 정보 초기화
		System.out.println("[Member1_rList] pageMaker="+pageMaker);

		List<Member1_rVO> searchMember1_rList = m1rService.getListWithPaging(criteria,key);

		model.addAttribute("searchM1rList", searchMember1_rList);
		model.addAttribute("searchM1rListSize", totalCount);
		model.addAttribute("pageMaker", pageMaker);
		
		model.addAttribute("searchKey", key);
		
		System.out.println("searchM1rList="+searchMember1_rList);
		System.out.println("searchM1rListSize="+totalCount);
		System.out.println("key=>"+key);
	
		return "search/m1rSearchList";
	}
	
	
}
